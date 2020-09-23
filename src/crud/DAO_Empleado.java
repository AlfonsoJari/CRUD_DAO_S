package crud;

import java.io.Serializable;
import java.sql.*;
import java.sql.SQLException;

public class DAO_Empleado implements Serializable {

    Empleado emp = new Empleado();

    //anadir un empleado
    public void anadirEmpleado(String clave, String nombre, String direccion, String telefono) throws SQLException {
        emp.setClave(clave);
        emp.setNombre(nombre);
        emp.setDireccion(direccion);
        emp.setTelefono(telefono);
        Statement statement = ConexionUnica.getInstance().getConnection().createStatement();
        statement.executeUpdate("INSERT INTO Empleados " + "VALUES ('" + emp.getClave() + "', '" + emp.getNombre() + "', '" + emp.getDireccion() + "', '" + emp.getTelefono() + "')");
        statement.close();
    }

    //eliminar un empleado por su clave
    public void eliminarCliente(String clave) throws SQLException {
        emp.setClave(clave);
        Statement statement = ConexionUnica.getInstance().getConnection().createStatement();
        statement.executeUpdate("DELETE FROM Empleados WHERE clave = " + emp.getClave());
        statement.close();
    }

    //actualizar un empleado por su clave
    public void actualizarEmpleado(String clave, String nombre, String direccion, String telefono) throws SQLException {
        emp.setClave(clave);
        emp.setNombre(nombre);
        emp.setDireccion(direccion);
        emp.setTelefono(telefono);
        Statement statement = ConexionUnica.getInstance().getConnection().createStatement();
        statement.executeUpdate("UPDATE Empleados SET nombre = '" + emp.getNombre() + "', direccion = '" + emp.getDireccion() + "', telefono = '" + emp.getTelefono() + "' WHERE clave = '" + emp.getClave() + "'");
        statement.close();
    }

}
