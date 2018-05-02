--Solucion Recursiva Clasica (Muy ineficiente)
combinatoria::(Int,Int)->Int
combinatoria (n,0) = 1
combinatoria (0,k) = 0
combinatoria (n,k) = combinatoria(n-1,k-1)+combinatoria(n-1,k)
