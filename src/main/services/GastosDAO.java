package services;

import modell.Categorias;
import modell.Gastos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GastosDAO extends Conexion {

    String sql;

    public boolean create (Gastos a) {
        Connection con = conectar();
        sql = "INSERT INTO gastos (idC, detallesG, fechaHora, importe, idU) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, a.getIdC());
            pt.setString(2, a.getDetallesG());
            pt.setString(3, String.valueOf(a.getFechaG()));
            pt.setDouble(4, a.getImporteG());
            pt.setInt(5, a.getIdUsuario());
            pt.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
        public boolean read (Gastos a){
            Connection con = conectar();
            sql = "SELECT * FROM gastos WHERE idC=? and detallesG=? importe=?, idU=?;";
            try {
                PreparedStatement pt = con.prepareStatement(sql);
                pt.setInt(1, a.getIdC());
                pt.setString(2, a.getDetallesG());
                pt.setDouble(3, a.getImporteG());
                pt.setInt(4, a.getIdUsuario());
                ResultSet rs = pt.executeQuery();
                return rs.next();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        public ArrayList readAll () {
            Connection con = conectar();
            ArrayList<Gastos> listGas = new ArrayList<>();
            sql = "SELECT * FROM gastos;";
            try {
                PreparedStatement pt = con.prepareStatement(sql);
                ResultSet rs = pt.executeQuery();
                while (rs.next()) {
                    int idC = rs.getInt("idC");
                    String detalleG = rs.getString("detallesG");
                    double  importeG = rs.getDouble("importeG");
                    int idU = rs.getInt("idU");

                    String fHora=rs.getString("fechaHora");
                    Gastos Gas = new Gastos(idC,fHora,detalleG,importeG,idU);
                    listGas.add(Gas);
                }
            } catch (SQLException e) {
                e.printStackTrace();

            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return listGas;
        }
    public ArrayList readAllTipo (int TipoTransaccion) {

        Connection con = conectar();
        ArrayList<Gastos> listGas=new ArrayList<>();

        sql = "select gastos.*,c.nombreC,c.idT from gastos inner join categorias c on gastos.idC = c.idC;";
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                if (TipoTransaccion==rs.getInt("idT")) {
                    int idC = rs.getInt("idC");
                    String detalleG = rs.getString("detallesG");
                    double importeG = rs.getDouble("importe");
                    String fHora=rs.getString("fechaHora");
                    int idU = rs.getInt("idU");
                    Gastos gas= new Gastos(fHora, idC,importeG, detalleG, idU);
                    System.out.println(gas.toString());
                    listGas.add(gas);//
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return listGas;
    }
    }

