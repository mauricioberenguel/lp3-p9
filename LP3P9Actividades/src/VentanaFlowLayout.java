import java.awt.FlowLayout;
import javax.swing.*;

public class VentanaFlowLayout extends JFrame 
{
    public VentanaFlowLayout() 
    {
        // Establecer el título de la ventana
        super("Ventana con FlowLayout");

        // Configurar el esquema de diseño FlowLayout
        setLayout(new FlowLayout()); // Los componentes se organizan horizontalmente por defecto

        // Crear los botones
        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");
        JButton boton3 = new JButton("Botón 3");

        // Agregar funcionalidad a los botones con ActionListener
        boton1.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Presionaste Botón 1");
        });

        boton2.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Presionaste Botón 2");
        });

        boton3.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Presionaste Botón 3");
        });

        // Añadir los botones al contenedor principal
        add(boton1); // Botón 1
        add(boton2); // Botón 2
        add(boton3); // Botón 3
    }
    public static void main(String[] args) 
    {
        // Crear instancia de la ventana principal
        VentanaFlowLayout ventana = new VentanaFlowLayout();

        // Configurar operación al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer tamaño de la ventana
        ventana.setSize(300, 150);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}