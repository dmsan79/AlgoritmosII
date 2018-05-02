-- BubbleSort hace n permutaciones para ordenar completamente la secuencia
-- 1) Permuto xs 
-- 2) El mas grande queda en su posicion por lo tanto lo saco y llamo recursivamente sin este elemento para 
--    acomodar el proximo mas grande mediante la proxima permutacion
-- 3) En cada llamada debo concatenar el elemeto eliminado (Mas grande ya en su pos.) para devolver la lista ordenada
bubbleSort::Ord a =>[a]->[a]
bubbleSort [] = []
bubbleSort [x] = [x]
bubbleSort xs = bubbleSort(init ys) ++ [last ys]
				where ys = permutaciones xs

--Realiza una pasada comparando el elemento con su siguiente y los ordena si estan desordenados
permutaciones::Ord a =>[a]->[a]
permutaciones [] = []
permutaciones [x] = [x]
permutaciones (x:y:xs) | x<y = [x]++permutaciones (y:xs)
					   | otherwise = [y]++permutaciones(x:xs) 
--Si la lista esta ordenada no se genera una nueva permutacion (No se intercambia ningun valor)
--Si hay un par desordenado, se genera una nueva permutacion con este par ordenado


