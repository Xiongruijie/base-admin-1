#! /usr/bin/python3
import sys
import os
import importlib

interactive_mode = 1
output_option = 0

if len(sys.argv) < 2:
    print("[Usage] python3 query_db.py db_file [expr_code]")
    print("        db_file is mandatory and expr_code is optional")
    print("        if expr_code is missed, interactive_mode will be used")
    print("        e.g. 1) python3 query_db.py db_1")
    print("        or   2) python3 query_db.py db_1 65367621")
    exit()

db_file = sys.argv[1]
if os.path.exists(db_file+'.py') is False:
    print("Can't find %s.py"%db_file)
    exit()

params = importlib.import_module(db_file)
dict_expr_name = params.dict_expr_name
dict_taxn_name = params.dict_taxn_name
dict_sele_name = params.dict_sele_name
list_data_base = params.list_data_base
dict_spp_name  = params.dict_spp_name
list_usel_seqn = params.list_usel_seqn
list_data_tval = params.list_data_tval

out_file = db_file+".res.md"

if len(sys.argv) == 3:
    interactive_mode = 0
    user_input = sys.argv[2]

#---------------------------------------------------------------------

topN = 7
dict_remk_name = {
  0:'极好的鉴定结果',
  1:'很好的鉴定结果',
  2:'好的鉴定结果',
  3:'可接受的鉴定结果',
  4:'可疑的鉴定结果',
  5:'不可接受的鉴定结果',
}

#---------------------------------------------------------------------
# 1-计算百分比
# 对每个taxon，根据select_input，计算该taxon在所有的select试验的乘积
# 假设list_database中对应值为a，则在计算时，
# 如果输入为+，则取值为a
# 如果输入为-, 则取值为100-a
# 如果输入为?，则取值为1
# 如果取值为0，需映射为1；如果取值为100，需映射为99。
# 计算结果存入列表，列表索引为taxon序号-1，计算列表之和
# 从中选错最大的5个，排序后存入另一个列表，元素是三元组
# 该三元组记录（taxon序号，百分比，原始乘积）
#---------------------------------------------------------------------
list_tops_seqn = []
list_tops_name = [] #
list_tops_prod = []
list_tops_perc = [] #
list_tops_tval = [] #
dict_sele_user = {}
dict_inco_expr = {} #
dict_comp_expr = {} #

#---------------------------------------------------------------------
# 2-计算T值
# 对每个taxon，根据select_input，计算该taxon在所有的select试验的乘积，并
#---------------------------------------------------------------------

#---------------------------------------------------------------------
# 3-不一致生化试验
#---------------------------------------------------------------------

#---------------------------------------------------------------------
def print_dict(name):
    for key in name:
        print(str(key)+':', end='')
        print(name[key])

def print_list(name):
    for x in name:
        print(x)

#---------------------------------------------------------------------
def prep_sele_user(user_input):
    # indicate if succeed
    flag = -1

    list_key = list(dict_sele_name.keys())
    quot = int(len(list_key)/3)
    rema = int(len(list_key)%3)
    if rema > 0:
        numb_grp = quot + 1
    else:
        numb_grp = quot

    permit = ['0','1','2','3','4','5','6','7']
    symbol = []

    if len(user_input) != int(numb_grp):
        print("\n"+"="*130)
        print("*ERROR* Your input length %d is not equal to permited length %d"%(len(user_input), numb_grp))
        print("="*130+"\n")
    else:
        for i,x in enumerate(user_input):
            if x not in permit:
                print("input must be 0~7")
                return -1

            a = int(x)

            if i == numb_grp-1 and rema != 0:
                if rema==1 and a>1:
                    print("The last number must be 0~1")
                    return -1
                elif rema==2 and a>3:
                    print("The last number must be 0~3")
                    return -1

            s3 = '+' if (a/4 >= 1) else '-'
            a = a-4 if (a/4 >= 1) else a
            s2 = '+' if (a/2 >= 1) else '-'
            a = a-2 if (a/2 >= 1) else a
            s1 = '+' if (a == 1) else '-'

            symbol.append(s1)
            symbol.append(s2)
            symbol.append(s3)

        for i,x in enumerate(list_key):
            dict_sele_user[x] = symbol[i]

        flag = 0

    return flag

#---------------------------------------------------------------------
def comp_prod_valu(list_taxn):
    prod = 1
    for j, key in enumerate(list(dict_sele_user.keys())):
        # step-1: locate database value a and exper input s
        # Since list starts from 0, so exper_key has to minus 1
        a = list_taxn[key-1]
        s = dict_sele_user[key]

        # step-2: adjust a in terms of s
        a = 100 - a if s == '-' else a
        a = 1 if a < 1 or s == '?' else a
        a = 99 if a == 100 else a

        # step-3: multiply
        prod = prod * a
    return prod


def comp_perc_tval():
    prod_list = []
    symb_list = []
    sum_value = 0
    for i, list_taxn in enumerate(list_data_base):
        if 'spp' in dict_taxn_name[i+1][0]:
            #print(dict_taxn_name[i+1][0])
            prod_list.append(0)
            continue
        prod = comp_prod_valu(list_taxn)

        # step-4: record products of all taxons and accumulate them
        prod_list.append(prod)
        sum_value += prod

    # step-5: find tops elements
    #print(prod_list)
    #print("sum_value=%d"%(sum_value))

    list_tops_tupl=[x for x in sorted(enumerate(prod_list), key=lambda x: x[1])[(0-topN):]]
    list_tops_seqn.clear()
    list_tops_name.clear()
    list_tops_prod.clear()
    list_tops_perc.clear()
    list_tops_tval.clear()

    for i in range(topN):
        indx,prod = list_tops_tupl[topN-1-i]
        seqn = indx + 1
        list_tops_seqn.append(seqn)
        list_tops_name.append(dict_taxn_name[seqn][0])
        list_tops_prod.append(prod)
        list_tops_perc.append(round(prod*100/sum_value, 2))
        list_tops_tval.append(round(prod*100/list_data_tval[indx],2))
#        list_topfv_perc.append("%.2f"%(prod*100/sum_value))
#        list_topfv_tval.append("%.2f"%(prod*100/list_database_tval[indx]))

#    print(list_tops_seqn)
#    print(list_tops_name)
##    print(list_tops_prod)
#    print(list_tops_perc)
#    print(list_tops_tval)

    return sum_value

#---------------------------------------------------------------------
# 只保留5个结果

def comp_remk_valu(perc, tval):
    if perc>=90 and tval>=90:
        remk = 0
    elif (perc>=90 and tval>=50) or (perc>=80 and tval>=60):
        remk = 1
    elif (perc>=90 and tval>=20) or (perc>=80 and tval>=30) or (perc>=70 and tval>=40) or (perc>=60 and tval>=50):
        remk = 2
    elif (perc>=90 and tval>=0) or (perc>=80 and perc<=90 and tval>=1) or (perc>=60 and perc<=80 and tval>=10):
        remk = 3
    elif (perc>=60 and perc<=90 and tval>=0.01) or (perc<60 and tval>=10):
        remk = 4
    elif (perc<60 and tval<10) or (perc<90 and tval<0.01):
        remk = 5
    return remk

def tune_tops_list(sum_value):
    perc = list_tops_perc[0]
    tval = list_tops_tval[0]
    remk = comp_remk_valu(perc, tval)

    name0 = list_tops_name[0].split(' ',1)[0]
    name1 = list_tops_name[1].split(' ',1)[0]
    name2 = list_tops_name[2].split(' ',1)[0]

    # 需要用spp替代计算的情况
    if remk >= 4 and name0 in dict_spp_name and dict_spp_name[name0][1]==2:
        seqn = dict_spp_name[name0][0]
        indx = seqn - 1
        list_taxn = list_data_base[indx]

        prod = comp_prod_valu(list_taxn)
        list_tops_seqn[0]=seqn
        list_tops_name[0]=dict_taxn_name[seqn][0]
        list_tops_perc[0]=round(prod*100/(sum_value+prod), 2)
        list_tops_tval[0]=round(prod*100/list_data_tval[indx],2)
        del list_tops_seqn[-2:]
        del list_tops_tval[-2:]
        del list_tops_name[-2:]
        del list_tops_perc[-2:]

    elif remk >=4 and name0 == name1 and name0 == name2 and name0 in dict_spp_name and dict_spp_name[name0][1]==3:
        seqn = dict_spp_name[name0][0]
        indx = seqn - 1
        list_taxn = list_data_base[indx]

        prod = comp_prod_valu(list_taxn)

        list_tops_seqn[0]=seqn
        list_tops_name[0]=dict_taxn_name[seqn][0]
        list_tops_perc[0]=list_tops_perc[0]+list_tops_perc[1]+list_tops_perc[2]
        list_tops_tval[0]=round(prod*100/list_data_tval[indx],2)
        del list_tops_seqn[1:3]
        del list_tops_tval[1:3]
        del list_tops_name[1:3]
        del list_tops_perc[1:3]

    else:
        del list_tops_seqn[-2:]
        del list_tops_tval[-2:]
        del list_tops_name[-2:]
        del list_tops_perc[-2:]

    perc = list_tops_perc[0]
    tval = list_tops_tval[0]
    remk = comp_remk_valu(perc, tval)

    return remk

#---------------------------------------------------------------------

def prep_data_tval():
    for i, list_taxn in enumerate(list_data_base):
        prod = 1
        for j, expr_key in enumerate(list(dict_sele_name.keys())):
            # step-1: locate database value a
            # Since list starts from 0, so exper_key has to minus 1
            a = list_taxn[expr_key-1]

            # step-2: adjust a
            a = 100 - a if a<50 else a
            a = 1 if a < 1 else a
            a = 99 if a == 100 else a

            # step-3: multiply
            prod = prod * a

        # step-4: record products of all taxons
        list_data_tval.append(prod)
    print(list_data_tval)
    return 1

#---------------------------------------------------------------------

def comp_inco_expr():
    dict_inco_expr.clear()
    for i, key in enumerate(dict_sele_name.keys()):
        list_inco = []
        # step-1: acquire chinese name for select exper
        name = dict_sele_name[key][1]
        # step-2: acquire user input for select exper
        s = dict_sele_user[key]
        # step-3: iterate tops
        for seqn in list_tops_seqn:
            indx = seqn - 1
            list_taxn = list_data_base[indx]
            # step-4: acuqire database value a
            a = list_taxn[key-1]

            # step-5: adjust a in terms of s and insert into list
            a = a if ((a>=75 and s=='-') or (a<=25 and s=='+')) else -1
            list_inco.append(a)

        if sum(list_inco) != -5:
            dict_inco_expr[name] = list_inco

    return


#---------------------------------------------------------------------

def prep_usel_seqn():
    a = set(dict_expr_name.keys())
    b = set(dict_sele_name.keys())
    list_usel_seqn.extend(list(a.difference(b)))
    #print(list_usel_seqn)
    return

#---------------------------------------------------------------------

# 先用75-25生成+，-，NA，如果都是NA，就用50-50区分
# 需统计+和-个数
# 用1表示+，用0表示-，用6表示NA
# sum(list)就是+的个数
# 因为最多只有5个taxon，所以如果有NA，则sum一定大于等于6，这样就检测出NA

# 需要遍历二叉树生成补充生化试验
# 1）维持一个列表a，该列表的元素还是一个列表，记录所有需要分类的taxon，当该列表为空时就退出循环
# 2）维持一个列表b，记录需要考察的生化反应

# 初始，所有5个taxon的list会进入列表a，所有unselect进入列表b。对b遍历，一边生成+-NA，一边计算N+^2+N-^2
# 遍历结束求出最小值对应的生化，放入结果字典，在b中删除该生化；
# 在a中根据+-放入2个不同的元素，分别记录+和-对应的taxon调整
# 调整列表a指针+1，如果指针小于列表长度，就继续，否则退出循环

# 计算补充生化试验
def comp_comp_expr():
    list_taxn_dyn = []
    list_taxn_dyn.append(list_tops_seqn)
    list_usel_dyn = list_usel_seqn.copy()


    i = 0
    list_usel_sumN = []
    dict_usel_data = {} # record tops data for each usel
    list_usel_symb = []
    while(1):
        if i == len(list_taxn_dyn):
            break
        list_usel_sumN.clear()
        list_usel_symb.clear()
        for usel_seqn in list_usel_dyn:
            list_a_val = []
            list_75_25 = []
            list_50_50 = []
            for taxn_seqn in list_taxn_dyn[i]:
                list_taxn_val = list_data_base[taxn_seqn-1]
                a = list_taxn_val[usel_seqn-1]
                list_a_val.append(a)

                if a>=75:
                    list_75_25.append(1)
                elif a<=25:
                    list_75_25.append(0)
                else:
                    list_75_25.append(6)

                if a>=50:
                    list_50_50.append(1)
                else:
                    list_50_50.append(0)

            if i == 0:
                dict_usel_data[usel_seqn]=list_a_val

            Np = sum(list_75_25)
            tl = len(list_75_25)

            if Np == tl*6:
                Np = sum(list_50_50)
                list_usel_symb.append(list_50_50)
            else:
                list_usel_symb.append(list_75_25)

            # if 6(NA) is present, sum_of_N will be very large
            Nm = tl - Np
            sumN = Np*Np + Nm*Nm
            list_usel_sumN.append(sumN)

        minsum = min(list_usel_sumN)
        minidx = list_usel_sumN.index(minsum)

        seqn = list_usel_dyn[minidx]

        name = dict_expr_name[seqn][1]
        dict_comp_expr[name] = dict_usel_data[seqn]

#       print("minidx=%d"%(minidx))
#       print("seqn=%d"%(seqn))
#       print("name=%s"%(name))
#       print(dict_usel_data[seqn])

        list_usel_dyn.remove(seqn)

        list_taxn_plus = []
        list_taxn_mnus = []
        for j, s in enumerate(list_usel_symb[minidx]):
            if s == 1:
                list_taxn_plus.append(list_taxn_dyn[i][j])
            else:
                list_taxn_mnus.append(list_taxn_dyn[i][j])

        numb_taxn_plus = len(list_taxn_plus)
        numb_taxn_mnus = len(list_taxn_mnus)
        if numb_taxn_plus > 1 and numb_taxn_mnus !=0:
            list_taxn_dyn.append(list_taxn_plus)

        if numb_taxn_mnus > 1 and numb_taxn_plus !=0:
            list_taxn_dyn.append(list_taxn_mnus)

#       print("--------start of i=%d---------"%i)
#       print(list_usel_sumN)
#       print(list_usel_symb)
#       print("minidx=%d"%minidx)
#       print(list_usel_symb[minidx])
#       print(list_taxn_plus)
#       print(list_taxn_mnus)
#       print("--------end of i=%d---------"%i)

        i = i + 1

    return

#---------------------------------------------------------------------
def print_remk_name(remk):
    result = dict_remk_name[remk]+': '+list_tops_name[0]
    print(result)
    return (dict_remk_name[remk], list_tops_name[0])

def print_sele_user(user_input):
    if user_input != 0:
        print("【用户输入】")
    for i,key in enumerate(dict_sele_name):
        print(f"{dict_sele_name[key][0]:^6}", end='|' if (i+1)%3==0 else '')
    print()

    if user_input == 0:
        for i,key in enumerate(dict_sele_name):
            if i%3 == 0:
                a = "1"
            elif i%3 == 1:
                a = "2"
            elif i%3 == 2:
                a = "4"
            print(f"{a:^6}",end='|' if (i+1)%3==0 else '')
        print()
    else:
        for i,key in enumerate(dict_sele_user):
            print(f"{dict_sele_user[key][0]:^6}", end='|' if (i+1)%3==0 else '')
        print()
        for s in user_input:
            print(f"{s:^18}", end='|')
        print()

    return

#---------------------------------------------------------------------
def print_result(remk,fp):
    print("\n")
    print("="*130)
    print_sele_user(user_input)
    print("-"*130)
    print("【前5类菌种】")
    print(list_tops_seqn)
    print(list_tops_name)
    print("【鉴定百分比】")
    print(list_tops_perc)
    print("【T值】")
    print(list_tops_tval)
    print("-"*130)
    print("【不一致试验】")
    print_dict(dict_inco_expr)
    print("-"*130)
    print("【补充生化试验】")
    print_dict(dict_comp_expr)
    print("-"*130)
    print("【结果评价】")
    result = print_remk_name(remk)
    print("="*130)
    print("\n")

#   #用户输入
#   fp.write("user,"+user_input+'\n')
#   #菌种名称
#   fp.write("name,")
#   for x in list_tops_name:
#       fp.write(x+',')
#   fp.write('\n')
#   #百分比
#   fp.write("perc,")
#   for x in list_tops_perc:
#       fp.write(str(x)+',')
#   fp.write('\n')
#   #T值
#   fp.write("tval,")
#   for x in list_tops_tval:
#       fp.write(str(x)+',')
#   fp.write('\n')
#   #不一致试验
#   fp.write("inconsistent experiments\n")
#   for k in dict_inco_expr:
#       fp.write(k+',')
#       for y in dict_inco_expr[k]:
#           fp.write(str(y)+',')
#       fp.write('\n')
#   #补充生化试验
#   fp.write("complementary experiments\n")
#   for k in dict_comp_expr:
#       fp.write(k+',')
#       for y in dict_comp_expr[k]:
#           fp.write(str(y)+',')
#       fp.write('\n')
#   #结果评价
#   fp.write("result,"+result+'\n')

    #用户输入#
    fp.write("<table>\n")

    fp.write("<tr>\n")
    fp.write("<td><b>用户编码</b></td>\n")
    fp.write("<td>%s</td>\n"%(user_input))
    fp.write("<td><b>结果评价</b></td>\n")
    fp.write("<td colspan='2'>%s</td>\n"%(result[0]))
    fp.write("<td>%s</td>\n"%(result[1]))
    fp.write("</tr>\n")

    fp.write("<tr>\n")
    fp.write("<td><b>菌种名称</b></td>\n")
    for x in list_tops_name:
        fp.write("<td>%s</td>\n"%(x))
    fp.write("</tr>\n")

    fp.write("<tr>\n")
    fp.write("<td><b>鉴定百分比</b></td>\n")
    for x in list_tops_perc:
        if x>99.99:
            fp.write("<td>99.9</td>\n")
        elif x<0.01:
            fp.write("<td><0.01</td>\n")
        else:
            fp.write("<td>%s</td>\n"%(str(x)))
    fp.write("</tr>\n")

    fp.write("<tr>\n")
    fp.write("<td><b>T值</b></td>\n")
    for x in list_tops_tval:
        fp.write("<td>%s</td>\n"%(str(x)))
    fp.write("</tr>\n")

    fp.write("<tr>\n")
    fp.write("<td colspan='6'><b>不一致试验</b></td>\n")
    fp.write("</tr>\n")

    for k in dict_inco_expr:
        fp.write("<tr>\n")
        fp.write("<td>%s</td>\n"%(k))
        for y in dict_inco_expr[k]:
            if y==-1:
                fp.write("<td></td>\n")
            else:
                fp.write("<td>%s</td>\n"%(str(y)))
        fp.write("</tr>\n")

    fp.write("<tr>\n")
    fp.write("<td colspan='6'><b>补充生化试验</b></td>\n")
    fp.write("</tr>\n")

    for k in dict_comp_expr:
        fp.write("<tr>\n")
        fp.write("<td>%s</td>\n"%(k))
        for y in dict_comp_expr[k]:
            fp.write("<td>%s</td>\n"%(str(y)))
        fp.write("</tr>\n")

    fp.write("</table>\n")

    return 0

#---------------------------------------------------------------------
def main():
    global interactive_mode,user_input,out_file

    fp = open(out_file, 'w', encoding='utf-8',errors='ignore')

    while(1):
        if interactive_mode == 1:
            print_sele_user(0)
            user_input = input('请以3项一组输入生化反应编号，quit退出:')
            if (user_input == "quit") :
                break
        flag = prep_sele_user(user_input)
        if flag == 0:
            sumv = comp_perc_tval()
            remk = tune_tops_list(sumv)
            comp_inco_expr()
            comp_comp_expr()
            print_result(remk,fp)
        if interactive_mode == 0:
            break

    fp.close()
    return flag


#---------------------------------------------------------------------
if __name__ == "__main__":
    main()
