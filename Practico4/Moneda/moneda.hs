conquistar::[Int]->[Int]
conquistar xs | sum(fst x) > sum(snd x) = fst x
			  | otherwise = snd x
			  where x = (take (length xs `div` 2) xs, drop (length xs `div` 2) xs)

moneda:: [Int]->[Int]
moneda [x] = [x]
moneda xs = moneda(conquistar xs)