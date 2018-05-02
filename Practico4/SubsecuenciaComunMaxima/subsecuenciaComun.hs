subsecuenciaComun:: [Char]->[Char]->[Char]
subsecuenciaComun [] [] = []
subsecuenciaComun xs [] = []
subsecuenciaComun [] ys = []
subsecuenciaComun (x:xs) (y:ys) | x==y = x:subsecuenciaComun xs ys
								| otherwise = maximaSecuencia (subsecuenciaComun (x:xs) ys) (subsecuenciaComun xs (y:ys))

maximaSecuencia:: [Char]->[Char]->[Char]
maximaSecuencia xs ys | length(xs) > length(ys) = xs
					  | otherwise = ys