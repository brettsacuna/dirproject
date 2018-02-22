package dao;

import database.DataAccess;
import entity.TipoUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoUsuarioDao implements Intermetodos<TipoUsuario> {

    @Override
    public void Grabar(TipoUsuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Modificar(TipoUsuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Eliminar(TipoUsuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoUsuario> Listar() throws Exception {
        Connection cn = null;
        List<TipoUsuario> lista = new ArrayList<TipoUsuario>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select id_tipo_usuario, tipo_usuario from tipo_usuario "
                    + " where activo = 1 order by id_tipo_usuario asc ";
            // crear statement
            Statement stm = cn.createStatement();
            // ejecutar comando y obtener resultados
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                TipoUsuario tu = new TipoUsuario();
                //asignar valores al objeto r
                tu.setTipo_usuario_id(rs.getInt("id_tipo_usuario"));
                tu.setTipo_usuario(rs.getString("tipo_usuario"));
                lista.add(tu);
            }
            // cerrar cursor
            rs.close();
            stm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return lista;
    }

    @Override
    public List<TipoUsuario> Filtrar(TipoUsuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoUsuario Buscar(TipoUsuario o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
