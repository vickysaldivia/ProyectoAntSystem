# ProyectoAntSystem - Victoria Saldivia, Jonathan Sarli, Giampiero Bastidas

Se desarrolla un algoritmo que permita hallar el camino más óptimo haciendo uso de un algoritmo de optimización basado en el comportamiento de colonias de hormigas.

Para este proyecto se consideran las siguientes ideas generales para el funcionamiento del sistema:
1. La hormiga debe visitar cada ciudad exactamente una vez.
2. Una ciudad más distante tiene menos probabilidad de ser seleccionada (visibilidad).
3. Cuanto más intensa sea la senda de feromonas entre dos ciudades, mayor será la probabilidad de que esa senda sea elegida.
4. Después de completar su recorrido, la hormiga deposita más feromonas en todas las sendas que recorrió, si el recorrido es corto.
5. Después de cada iteración, las sendas de feromonas se evaporan.
