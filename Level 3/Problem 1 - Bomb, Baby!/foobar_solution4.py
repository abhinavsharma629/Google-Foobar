def solution(x, y):
	x=(int)(x)
	y=(int)(y)
	if(x==y and x==1):
		return "0"
	elif(x==1):
		return str(y-1)
	elif(y==1):
		return str(x-1)
	elif(y%x==0 or x%y==0):
		return "impossible"
	else:
		count=0
		while(x!=1 and y!=1 and y>1 and x>1):
			div=0

			if(y>x):
				mod=y%x
				div=y//x
				y-=x*div

			else:
				mod=x%y
				div=x//y
				x-=y*div

			count+=div

		if(x==1):
			return str(count+(y-1))
		elif(y==1):
			return str(count+(x-1))
		else:
			return "impossible"


print(solution("15","22"))
print(solution("4","7"))
print(solution("2","4"))
print(solution("3","2"))
print(solution("2","1"))
