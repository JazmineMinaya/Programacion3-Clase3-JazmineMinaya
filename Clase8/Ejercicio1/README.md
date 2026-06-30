# Preguntas

## 1. ¿Cuál es la diferencia entre ActionEvent, MouseEvent y KeyEvent?
Su diferencia radica en que ActionEvent se produce a la hoen que el usuario ejecuta una acción sobre algún componente de la interfez, a diferencia de MouseEvent, este se encarga de detectar las interacciones realizadas por el usuario con respecto el mouse, ya sea al hacer clic, mover el cursor o simplemente arrastrarlo. Y por último, KeyEvent, este, a diferencia de los primeros dos, responde únicamente a las acciones del teclado.

## 2. ¿Por qué es mejor separar la vista en FXML y la lógica en el Controller?
Porque permite mantener el diseño de la interfaz y la lógica del programa de foma independiente, lo que garantiza la facilidad del mantenimiento de este.

## 3. ¿Qué función cumple @FXML?
La función de @FXML se encarga de permitir el enlace entre los componentes y los métodos definidos en el archivo FXML con el Controller.

## 4. ¿Qué ocurre si el nombre del método en el FXML no coincide con el método del Controller?
En este caso, JavaFX no encontraría el método, provocando así que este genere un error al ejecutar la aplicación, por consiguiente, impide que el evento funcione correctamente.

## 5. ¿Por qué es recomendable usar CSS en lugar de colocar estilos directamente en Java?
Porque permite separar el diseño de la lógica del programa, mejorando así la organización y el mantenimiento del proyecto.