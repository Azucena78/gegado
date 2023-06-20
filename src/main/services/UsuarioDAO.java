package services;

import modell.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class UsuarioDAO extends Conexion {
    String sql;

    public boolean create(Usuario u) {
        sql = "INSERT INTO usuario (userN, passU) VALUES (?,?);";
        Connection con = conectar();
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, u.getUserN());
            pt.setString(2, u.getPassU());
            pt.executeUpdate();
            con.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean read(Usuario u) {
        sql = "SELECT * FROM usuario WHERE userN=? and passU=?;";
        Connection con = conectar();
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, u.getUserN());
            pt.setString(2, u.getPassU());
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

    public boolean update(Usuario u) {
        if (readU(u.getUserN())) {
            sql = "UPDATE usuario SET passU=? WHERE userN=?;";
            Connection con = conectar();
            try {
                PreparedStatement pt = con.prepareStatement(sql);
                pt.setString(1, u.getPassU());
                pt.setString(2, u.getUserN());
                pt.executeUpdate();
                return true;
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
        }else
        return false;
    }

    public boolean readU(String userN) {
        Usuario u = null;
        sql = "SELECT * FROM usuario WHERE userN=?;";
        Connection con = conectar();
        try {

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, userN);
            ResultSet rs = pt.executeQuery();
           return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public Usuario readUsuarioSesion(Usuario u) {
        sql = "SELECT * FROM usuario WHERE userN=? and passU=?;";
        Connection con = conectar();
        Usuario user=null;
        try {
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, u.getUserN());
            pt.setString(2, u.getPassU());
            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                int idU=rs.getInt("idU");
                String userN=u.getUserN();
                String passU=u.getPassU();
                user=new Usuario(userN,passU,idU);
                return user;
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
        return user;
    }

}
