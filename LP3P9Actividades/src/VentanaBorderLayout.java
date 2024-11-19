import java.awt.BorderLayout;
import javax.swing.*;

public class VentanaBorderLayout extends JFrame 
{

    public VentanaBorderLayout() {
        // Establecer el título de la ventana
        super("Ventana con BorderLayout");

        // Configurar el esquema de diseño de la ventana
        setLayout(new BorderLayout());

        // Crear los componentes de la interfaz
        JButton botonNorte = new JButton("Norte"); // Botón superior
        JButton botonSur = new JButton("Sur"); // Botón inferior
        JButton botonEste = new JButton("Este"); // Botón lateral derecho
        JButton botonOeste = new JButton("Oeste"); // Botón lateral izquierdo
        JTextArea areaCentro = new JTextArea("Área central"); // Área central de texto

        // Envolver el área central en un JScrollPane para permitir desplazamiento
        JScrollPane scrollPaneCentro = new JScrollPane(areaCentro);

        // Agregar los componentes al contenedor principal usando BorderLayout
        add(botonNorte, BorderLayout.NORTH); // Agregar botón al borde norte (superior)
        add(botonSur, BorderLayout.SOUTH); // Agregar botón al borde sur (inferior)
        add(botonEste, BorderLayout.EAST); // Agregar botón al borde este (derecha)
        add(botonOeste, BorderLayout.WEST); // Agregar botón al borde oeste (izquierda)
        add(scrollPaneCentro, BorderLayout.CENTER); // Agregar área de texto al centro

        // Configurar funcionalidad para los botones con ActionListener
        botonNorte.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Norte presionado");
        });

        botonSur.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Sur presionado");
        });

        botonEste.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Este presionado");
        });

        botonOeste.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Botón Oeste presionado");
        });

        // Configurar área central para que no sea editable
        areaCentro.setEditable(false);
    }
    public static void main(String[] args) 
    {
        // Crear instancia de la ventana principal
        VentanaBorderLayout ventana = new VentanaBorderLayout();

        // Configurar operación al cerrar la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Establecer tamaño de la ventana
        ventana.setSize(400, 200);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}