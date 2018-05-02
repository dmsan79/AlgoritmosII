---------- Realiza todas las permitaciones de una lista -----------------------
perm :: [Int] -> [[Int]]
perm [] = [[]]
perm (x:xs) = concat (map (interleave x) (perm xs))

interleave :: Int -> [Int] -> [[Int]]
interleave x [] = [[x]]
interleave x (y:ys) = (x:(y:ys)):(map (y:) (interleave x ys))

----- Dada una lista genera las posiciones de las 8 reinas (lista de 8 pares)---
generarPares:: [Int]->[(Int,Int)]
generarPares [] = []
generarPares (x:xs)= (length xs +1,last (x:xs)):generarPares (init (x:xs))

------ Genera todas las posibles ubicaciones de las 8 reinas -------------------
generarParesTotales::[Int]->[[(Int,Int)]]
generarParesTotales [] = []
generarParesTotales xs = map (generarPares) (perm xs)


------------- Vemos si en la lista de pares alguna reina se intersecta ------------------------------
cumpleCond::[(Int,Int)]-> Bool
cumpleCond [] = True
cumpleCond [x] = True
cumpleCond (x:y:xs) | abs(fst(x)-fst(y))==abs(snd(x)-snd(y)) = False
				    | abs(fst(x)-fst(y))/=abs(snd(x)-snd(y)) = cumpleCond (x:xs) && cumpleCond (y:xs)

------------- Devuelve la primera lista de 8 pares que no se intersectan -----------------------------
solucion::[[(Int,Int)]]->[(Int,Int)]
solucion [] = []
solucion (x:xs) | cumpleCond (x) = x
				| otherwise = solucion xs

-------------------------------------- SOLUCION GENERAL -------------------------------------------
-- Construimos la solucion a partir de poner una REINA EN CADA FILA (Arreglo pasado como parametro) 
solucionGeneral :: [Int]->[(Int,Int)]
solucionGeneral xs = solucion(generarParesTotales xs)