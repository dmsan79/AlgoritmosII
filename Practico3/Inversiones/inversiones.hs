fsthalf :: [a] -> [a]
fsthalf xs = take (length xs `div` 2) xs

sndhalf :: [a] -> [a]
sndhalf xs = drop (length xs `div` 2) xs

merge :: Ord a => [a] -> [a] -> Int-> ([a],Int)
merge xs [] n = (xs,n)
merge [] ys n = (ys,n)
merge (x:xs) (y:ys) n 
         | (x <= y)  = x:(merge xs (y:ys) n)  
         | otherwise = y:(merge (x:xs) ys (n+1))

mergesort :: Ord a => [a] -> ([a],int)
mergesort [] = ([],0)
mergesort [x] = ([x],0)
mergesort xs = merge (mergesort (fsthalf xs)) (mergesort (sndhalf xs)) 0