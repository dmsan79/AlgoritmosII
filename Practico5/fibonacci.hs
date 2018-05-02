-- fib n = (fin n-1, fib n) 
fib::Int->(Int,Int)
fib 0 = (1,0)
fib 1 = (1,1)
fib n = (snd(x) , fst(x) + snd(x))
	    where x = fib (n-1)

fibonacci::Int->Int
fibonacci n = snd(fib n)