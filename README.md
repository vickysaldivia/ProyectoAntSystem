# ProyectoAntSystem - Victoria Saldivia, Jonathan Sarli, Giampiero Bastidas

Se desarrolla un algoritmo que permita hallar el camino más óptimo haciendo uso de un algoritmo de optimización basado en el comportamiento de colonias de hormigas.

Para este proyecto se consideran las siguientes ideas generales para el funcionamiento del sistema:
1. La hormiga debe visitar cada ciudad exactamente una vez.
2. Una ciudad más distante tiene menos probabilidad de ser seleccionada (visibilidad).
3. Cuanto más intensa sea el rastro de feromonas entre dos ciudades, mayor será la probabilidad de que ese camino sea elegido.
4. Después de completar su recorrido, la hormiga deposita más feromonas en todas caminos que recorrió.
5. Después de cada iteración, el rastro de feromonas se evapora progresivamente.
