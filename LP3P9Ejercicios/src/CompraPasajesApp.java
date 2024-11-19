import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompraPasajesApp {

    public static void main(String[] args) {
        // Crear el marco principal de la aplicación
        JFrame frame = new JFrame("Compra de Pasajes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configurar cierre al cerrar la ventana
        frame.setSize(500, 600); // Establecer tamaño de la ventana
        frame.setLayout(new GridBagLayout()); // Usar GridBagLayout para una disposición flexible
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL; // Extender componentes horizontalmente

        // Etiquetas y campos de texto para el formulario
        JLabel nombreLabel = new JLabel("Nombre:"); // Etiqueta para el nombre
        JTextField nombreField = new JTextField(); // Campo de texto para ingresar el nombre

        JLabel idLabel = new JLabel("Documento de Identidad:"); // Etiqueta para el ID
        JTextField idField = new JTextField(); // Campo de texto para el ID

        JLabel fechaLabel = new JLabel("Fecha de Viaje (dd-mm-aaaa):"); // Etiqueta para la fecha
        JTextField fechaField = new JTextField(); // Campo de texto para ingresar la fecha

        // Casillas de verificación para servicios adicionales
        JLabel serviciosLabel = new JLabel("Servicios Opcionales:");
        JCheckBox audifonosCheck = new JCheckBox("Audífonos"); // Checkbox para audífonos
        JCheckBox mantaCheck = new JCheckBox("Manta"); // Checkbox para manta
        JCheckBox revistasCheck = new JCheckBox("Revistas"); // Checkbox para revistas

        // Botones de opción para selección de piso
        JLabel pisoLabel = new JLabel("Piso:");
        JRadioButton primerPiso = new JRadioButton("1er Piso"); // Opción para el primer piso
        JRadioButton segundoPiso = new JRadioButton("2do Piso"); // Opción para el segundo piso
        ButtonGroup pisoGroup = new ButtonGroup(); // Grupo para asegurarse de que solo un botón esté seleccionado
        pisoGroup.add(primerPiso);
        pisoGroup.add(segundoPiso);

        // Combobox para seleccionar origen y destino
        JLabel origenLabel = new JLabel("Lugar de Origen:");
        JComboBox<String> origenCombo = new JComboBox<>(new String[]{"Ciudad A", "Ciudad B", "Ciudad C"});

        JLabel destinoLabel = new JLabel("Lugar de Destino:");
        JComboBox<String> destinoCombo = new JComboBox<>(new String[]{"Ciudad X", "Ciudad Y", "Ciudad Z"});

        // Lista para calidad del servicio
        JLabel servicioLabel = new JLabel("Calidad del Servicio:");
        JList<String> servicioList = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        JScrollPane servicioScroll = new JScrollPane(servicioList); // Agregar scroll para la lista

        // Botones para realizar acciones
        JButton comprarButton = new JButton("Comprar"); // Botón para confirmar compra
        JButton resetButton = new JButton("Reiniciar"); // Botón para reiniciar el formulario

        // Organización del formulario en la ventana
        // Añadir componentes al marco con sus coordenadas
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(nombreLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        frame.add(nombreField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(idLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        frame.add(idField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(fechaLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(fechaField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(serviciosLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        JPanel serviciosPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel para agrupar checkboxes
        serviciosPanel.add(audifonosCheck);
        serviciosPanel.add(mantaCheck);
        serviciosPanel.add(revistasCheck);
        frame.add(serviciosPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(pisoLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 4;
        JPanel pisoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Panel para agrupar opciones de piso
        pisoPanel.add(primerPiso);
        pisoPanel.add(segundoPiso);
        frame.add(pisoPanel, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        frame.add(origenLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        frame.add(origenCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        frame.add(destinoLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 6;
        frame.add(destinoCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 7;
        frame.add(servicioLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 7;
        frame.add(servicioScroll, gbc);

        gbc.gridx = 0; gbc.gridy = 8; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER; // Centrar los botones
        JPanel buttonsPanel = new JPanel(); // Panel para agrupar botones
        buttonsPanel.add(comprarButton);
        buttonsPanel.add(resetButton);
        frame.add(buttonsPanel, gbc);

        // Acción para realizar la compra y mostrar el resumen
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Validar documento de identidad
                String idText = idField.getText().trim(); // Obtener el texto ingresado
                if (!idText.matches("\\d{8}")) { // Verificar que tenga 8 dígitos
                    JOptionPane.showMessageDialog(frame, "El Documento de Identidad debe contener 8 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Detener ejecución si no es válido
                }

                // Validar formato de la fecha
                String fechaText = fechaField.getText().trim(); // Obtener la fecha ingresada
                if (!fechaText.matches("\\d{2}-\\d{2}-\\d{4}")) { // Verificar formato
                    JOptionPane.showMessageDialog(frame, "La fecha debe estar en formato dd-mm-aaaa.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Construir el resumen de la compra
                StringBuilder resumen = new StringBuilder();
                resumen.append("Nombre: ").append(nombreField.getText()).append("\n");
                resumen.append("Documento de Identidad: ").append(idText).append("\n");
                resumen.append("Fecha de Viaje: ").append(fechaText).append("\n");
                resumen.append("Servicios Opcionales: ");
                if (audifonosCheck.isSelected()) resumen.append("Audífonos ");
                if (mantaCheck.isSelected()) resumen.append("Manta ");
                if (revistasCheck.isSelected()) resumen.append("Revistas ");
                resumen.append("\n");
                resumen.append("Piso: ").append(primerPiso.isSelected() ? "1er Piso" : "2do Piso").append("\n");
                resumen.append("Origen: ").append(origenCombo.getSelectedItem()).append("\n");
                resumen.append("Destino: ").append(destinoCombo.getSelectedItem()).append("\n");
                resumen.append("Calidad del Servicio: ").append(servicioList.getSelectedValue()).append("\n");

                // Mostrar el resumen en un cuadro de diálogo
                JOptionPane.showMessageDialog(frame, resumen.toString(), "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Acción para reiniciar el formulario
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Restablecer todos los campos del formulario a sus valores iniciales
                nombreField.setText("");
                idField.setText("");
                fechaField.setText("");
                audifonosCheck.setSelected(false);
                mantaCheck.setSelected(false);
                revistasCheck.setSelected(false);
                pisoGroup.clearSelection();
                origenCombo.setSelectedIndex(0);
                destinoCombo.setSelectedIndex(0);
                servicioList.clearSelection();
            }
        });

        // Mostrar la ventana
        frame.setVisible(true); // Hacer visible la ventana
    }
}