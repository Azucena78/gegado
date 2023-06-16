package services;

import modell.Categorias;
import modell.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDAO extends Conexion {
    String sql;

    public boolean create (Categorias a) {
        Connection con = conectar();
        sql = "INSERT INTO categorias (nombreC, idT, icon) VALUES (?,?,?);";
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, a.getNombreC());
            pt.setInt(2, a.getIdT());
            pt.setString(3, a.getIconos());
            pt.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean read (Categorias a) {
        Connection con = conectar();
        sql = "SELECT * FROM categorias WHERE idT=? and nombreC=?;";
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, a.getIdT());
            pt.setString(2, a.getNombreC());
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
    public boolean delete (Categorias a) {
        Connection con = conectar();
        sql = "DELETE FROM categorias WHERE idT=? and nombreC=?;";

        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, a.getIdT());
            pt.setString(2, a.getNombreC());
            pt.executeUpdate();;
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public ArrayList readAll () {
        Connection con = conectar();
        ArrayList<Categorias> listCat=new ArrayList<>();

        sql = "SELECT * FROM categorias;";
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            ResultSet rs = pt.executeQuery();
            while ( rs.next()){
                int idC=rs.getInt("idC");
                String nombreC=rs.getString("nombreC");
                int idT=rs.getInt("idT");
                String icon=rs.getString("icon");
                Categorias cat=new Categorias(idC,nombreC,idT,icon);
                listCat.add(cat);
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
        return listCat;
    }
}
