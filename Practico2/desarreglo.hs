--Un desarreglo de n es una permutacion de p de {0, 1, ..., n} tal que ningun elemento coincide con la posicion
--en que se encuentra. Escriba un programa que, dado un valor n, calcule todos los desarreglos de n.
perm :: [a] -> [[a]]
perm [] = [[]]
perm (x:xs) = concat (map (interleave x) (perm xs))

interleave :: a -> [a] -> [[a]]
interleave x [] = [[x]]
interleave x (y:ys) = (x:(y:ys)):(map (y:) (interleave x ys))

-- Dice si una lista es un desarreglo
isDesarreglo:: [Int]->Bool
isDesarreglo []  = True
isDesarreglo xs | xs!!n == n = False
			    | otherwise = isDesarreglo (init xs)    
			    where n = (length xs)-1

-- Dada una lista de Arreglos devuelve aquellos que son desarreglos
listDesarreglos::[[Int]]->[[Int]]
listDesarreglos [] = []
listDesarreglos (x:xs) | isDesarreglo (x) = x:solucion xs
			           | otherwise = listDesarreglos xs

-- Dado un n calcula todos los desarreglos de n
desarreglos:: Int -> [[Int]]
desarreglos 0 = []
desarreglos n = listDesarreglos xs
				where xs = perm [x | x<-[0..n]]