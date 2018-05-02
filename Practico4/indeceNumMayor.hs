---------------------- Con Decrease and conquer ----------------------------
--(Recorro la lista de inicio a fin, si encuentro un mayor, guardo su indice)

--"n" guarda el indice que contiene el mayor y "m" el siguinte para analizar 
indiceMayor:: [Int]->Int->Int->(Int,Int) --(Num,indice)
indiceMayor xs n m | m>length(xs)-1 = (xs!!n,n)
				   | m/=length(xs) && xs!!n>xs!!m = indiceMayor xs n (m+1)
				   | m/=length(xs) && xs!!n<=xs!!m = indiceMayor xs m (m+1)


------------------- Con Fuerza Bruta------------------------------- 
--(Analizo todos los indices, por cada indice, veo si el el mayor) 

-- Veo si el indice "n" es el que contiene el maximo valor 
esMayor::[Int]->Int->Int->Bool
esMayor xs _ 0 = True
esMayor xs n m | xs!!n > xs!!(m-1) = esMayor xs n (m-1) 
			   | otherwise = False

-- Para cada indice "n" veo si es el mayor
indMayor::[Int]->Int->(Int,Int)
indMayor xs 0 = (xs!!0,0)
indMayor xs n | esMayor xs n (n-1) = (xs!!n,n)
			  | otherwise = martin2 xs (n-1)