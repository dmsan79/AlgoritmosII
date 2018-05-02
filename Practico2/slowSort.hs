perm :: [a] -> [[a]]
perm [] = [[]]
perm (x:xs) = concat (map (interleave x) (perm xs))

interleave :: a -> [a] -> [[a]]
interleave x [] = [[x]]
interleave x (y:ys) = (x:(y:ys)):(map (y:) (interleave x ys))

slowSort :: [Int] -> [Int]
slowSort xs = head (filter isSorted (perm xs))
            -- filter p xs (Lista de elementos que cumplen el predicado p)
            -- Al encontrar la primera la devuleve, no analiza todas las permutaciones
            -- por la evaluacion lazy
isSorted :: [Int] -> Bool
isSorted [] = True
isSorted [x] = True
isSorted (x1:(x2:xs)) = x1<=x2 && isSorted (x2:xs)
