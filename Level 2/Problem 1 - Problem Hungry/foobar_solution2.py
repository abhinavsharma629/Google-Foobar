def solution(xs):
    xs=sorted(xs)
    s=""
    sum=1
    last_ind=-1
    zero=0
    gr=0
    i=0
    for i in range(0,len(xs)):
        if(xs[i]>0):
            gr+=1
            sum*=xs[i]
            
        elif(xs[i]<0):
            last_ind=i
        else:
            zero+=1
            
    if(zero==len(xs)):
        sum=0
    elif(len(xs)==1):
        sum=xs[0]
    elif(last_ind!=-1):
        if(gr==0 and zero>=1 and (last_ind==0 or last_ind==-1)):
            sum=0
        else:
            tillWhere=1 if(last_ind%2==0) else 0
            for i in range(0,last_ind-tillWhere+1):
                sum*=xs[i]
						
    s=(str)(sum)
    return s


print(solution([2, 0, 2, 2, 0]))
