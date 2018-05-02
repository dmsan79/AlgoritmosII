----------------- Ejercicio a ------------------------------
perm :: [a] -> [[a]]
perm [] = [[]]
perm (x:xs) = concat (map (interleave x) (perm xs))

interleave :: a -> [a] -> [[a]]
interleave x [] = [[x]]
interleave x (y:ys) = (x:(y:ys)):(map (y:) (interleave x ys))

----------------- Ejercicio b -------------------------------
subconjunto::[a]->[[a]]
subconjunto [] = [[]]
subconjunto (x:xs) = map (x:) (subconjunto xs) ++ subconjunto xs

----------------- Ejercicio c -------------------------------
sublistas:: [a]->[[a]]
sublistas [] = [[]]
sublistas (x:xs) = subli (x:xs) ++ sublistas xs

subli:: [a]->[[a]]
subli [] = []
subli xs = xs:(subli (init xs))
