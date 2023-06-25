#! /usr/bin/python3
import sys
import re

#def process_line(line, num):
#    if line.strip() == '':
#        return
##    if re.match('##',line) is None and re.match('|', line):
##        return
#    if re.match('##',line) is not None:
#        a = line.split(" ")
#        cmmd = a[1].strip()
#        return 0
#    if re.search("repla", cmmd) is not None:
#        if num == 1 or num == 0: ## ignore the 1st & 2nd lines
#            return num+1
#        a = line.split('|')
#        key=a[1].strip().upper()
#        val=a[2].strip()
#        val=re.sub('` ','',val)
#        repl[key] = val
#        return num + 1
#    elif re.search("table", cmmd) is not None:
#        if num == 1: ## ignore the 2nd line
#            tbno = cmmd
#            return num+1
#        a = line.split('|')
#        if num == 0:
#            fun3 = re.sub("funct3 *=","",a[1])
#            fun3 = fun3.strip()
#            cols = a[2:-1]
#        else:
#            rows.append(a[1])
#            inst.append(a[2:-1])
#        return num + 1
#    elif re.search("prlog", cmmd) is not None:
#        if num == 1 or num == 0: ## ignore the 1st & 2nd lines
#            return num+1
#        a = line.split('|')
#        key=a[1].strip()
#        val=a[2].strip()
#        val=re.sub('` ','',val)
#        plog[key] = val
#        return num + 1

expr_name = 0
taxn_name = 0
sele_name = 0
data_base = 0
spp_name  = 0

expr_len = 0
taxn_len = 0
data_len = 0

usel_seqn = 0
data_tval = 0

dict_expr_name = {}
dict_taxn_name = {}
dict_sele_name = {}
list_data_base = []
dict_spp_name  = {}
list_usel_seqn = []
list_data_tval = []

# <config>
# 1. dict_expr_name
# 2. dict_taxn_name
# 3. dict_sele_name
# 4. list_data_base
# 5. dict_spp_name
# <deduce>
# 6. list_usel_seqn
# 7. list_data_tval
#----------------------------------

def process_line(idx, line, fp):
    global expr_name, taxn_name, sele_name, data_base, spp_name, expr_len, taxn_len, data_len
    # 空白行或者以#开头则不处理
    if line.strip() == '' or re.match('#', line) is not None:
        return 0
    # 去掉行尾回车符
    line = line.strip()
    # 提取%关键词%
    if re.match('%', line) is not None:
        l = line.strip('%')
        if l == 'dict_expr_name':
            expr_name = 1
            taxn_name = 0
            sele_name = 0
            data_base = 0
            spp_name  = 0
            fp.write('dict_expr_name={\n')
        elif l == 'dict_taxn_name':
            expr_name = 0
            taxn_name = 1
            sele_name = 0
            data_base = 0
            spp_name  = 0
            fp.write('dict_taxn_name={\n')
        elif l == 'dict_sele_name':
            expr_name = 0
            taxn_name = 0
            sele_name = 1
            data_base = 0
            spp_name  = 0
            fp.write('dict_sele_name={\n')
        elif l == 'list_data_base':
            expr_name = 0
            taxn_name = 0
            sele_name = 0
            data_base = 1
            spp_name  = 0
            fp.write('list_data_base=[\n')
        elif l == 'dict_spp_name':
            expr_name = 0
            taxn_name = 0
            sele_name = 0
            data_base = 0
            spp_name  = 1
            fp.write('dict_spp_name={\n')
        elif l == 'end' and data_base == 1:
            fp.write(']\n')
        elif l == 'end' and data_base == 0:
            fp.write('}\n')
        else:
            print('Undefined Data Encountered:%s'%(l))
            return -1
        return 0

    #填充数据
    if expr_name == 1:
        list_a = line.split(',')
        if len(list_a) != 3:
            print("Input Error! Experiment data is expected to contain 3 elements.")
            print("%d: %s"%(idx+1,line))
            return -1
        fp.write(list_a[0]+":('"+list_a[1]+"','"+list_a[2]+"'),\n")
        dict_expr_name[int(list_a[0])] = (list_a[1], list_a[2])
        expr_len += 1
    elif taxn_name == 1:
        list_a = line.split(',')
        if len(list_a) != 3:
            print("Input Error! Eaxonomy data is expected to contain 3 elements.")
            print("%d: %s"%(idx+1,line))
            return -1
        fp.write(list_a[0]+":('"+list_a[1]+"','"+list_a[2]+"'),\n")
        taxn_len += 1
    elif sele_name == 1:
        list_a = line.split(',')
        if len(list_a) != 3:
            print("Input Error! Selected experiment data is expected to contain 3 elements.")
            print("%d: %s"%(idx+1,line))
            return -1
        fp.write(list_a[0]+":('"+list_a[1]+"','"+list_a[2]+"'),\n")
        dict_sele_name[int(list_a[0])] = (list_a[1], list_a[2])
    elif data_base == 1:
        list_a = line.split(',')
        if len(list_a) != expr_len:
            print("Input Error! Data base length is expected to be %d but now it is %d"%(expr_len, len(list_a)))
            print("%d: %s"%(idx+1, line))
            return -1
        if '' in list_a:
            print("Input Error! Data base contains empty value!")
            print("%d: %s"%(idx+1, line))
            return -1
        list_data_base.append(list_a)
        fp.write("["+line+"],\n")
        data_len += 1
    elif spp_name == 1:
        list_a = line.split(',')
        if len(list_a) != 3:
            print("Input Error! Spp data is expected to contain 3 elements.")
            print("%d: %s"%(idx+1,line))
            return -1
        fp.write("'"+list_a[0]+"':("+list_a[1]+","+list_a[2]+"),\n")
    return 0

def prep_usel_seqn(fp):
    a = set(dict_expr_name.keys())
    b = set(dict_sele_name.keys())

    list_usel = sorted(list(a.difference(b)))
    fp.write('list_usel_seqn=[')
    for x in list_usel:
        fp.write(str(x))
        fp.write(',')
    fp.write(']\n')
    return

def prep_data_tval(fp):
    for i, list_taxn in enumerate(list_data_base):
        prod = 1
        for j, expr_key in enumerate(list(dict_sele_name.keys())):
            # step-1: locate database value a
            # Since list starts from 0, so exper_key has to minus 1
            a = eval(list_taxn[expr_key-1])

            # step-2: adjust a
            a = 100 - a if a<50 else a
            a = 1 if a < 1 else a
            a = 99 if a == 100 else a

            # step-3: multiply
            prod = prod * a

        # step-4: record products of all taxons
        list_data_tval.append(prod)
    fp.write('list_data_tval=[\n')
    for x in list_data_tval:
        fp.write(str(x))
        fp.write(',')
    fp.write(']\n')
    return 1

def main():
    global data_len, taxn_len
    if len(sys.argv) < 3:
        print("Please offer input and output.")
        return -1
    fn_i = sys.argv[1]
    fn_o = sys.argv[2]
    fp_i = open(fn_i,'r', encoding='utf-8',errors='ignore')
    fp_o = open(fn_o,'w', encoding='utf-8',errors='ignore')
    try:
        lines = fp_i.readlines()
        for idx,line in enumerate(lines):
            num = process_line(idx, line, fp_o)
            if num == -1:
                break
        if num ==0 and (data_len != taxn_len):
            print("data length(%d) is inconsistent with taxonomy length(%d)"%(data_len, taxn_len))
            num = -1
        if num==0:
            prep_usel_seqn(fp_o)
            prep_data_tval(fp_o)
    finally:
        fp_i.close()
        fp_o.close()
    return num

#---------------------------------------------------------------------
if __name__ == "__main__":
    main()
