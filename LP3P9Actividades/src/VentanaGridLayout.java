import java.awt.GridLayout;
import javax.swing.*;

public class VentanaGridLayout extends JFrame 
{
    public VentanaGridLayout() 
    {
        // Establecer el título de la ventana
        super("Ventana con GridLayout");

        // Configurar el esquema de diseño GridLayout (3 filas x 3 columnas)
        setLayout(new GridLayout(3, 3));

        // Crear y agregar botones al contenedor
        for (int i = 1; i <= 9; i++) 
        {
            // Crear un botón con el texto "Botón X" donde X es el número del botón
            JButton boton = new JButton("Botón " + i);

            // Agregar funcionalidad al botón para mostrar un mensaje al presionarlo
            boton.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Presionaste " + boton.getText());
            });

            // Añadir el botón al contenedor principal
            add(boton);
        }
    }
    public static void main(String[] args) 
    {
        // Crear instancia de la ventana principal
        VentanaGridLayout ventana = new VentanaGridLayout();

        // Configurar operación al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer el tamaño de la ventana
        ventana.setSize(300, 300);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}