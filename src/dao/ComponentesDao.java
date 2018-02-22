package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Componentes;

public class ComponentesDao implements Intermetodos<Componentes>{

	@Override
	public void Grabar(Componentes o) throws Exception {
		Connection cn = null;
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " insert into componentes("
					+" id_proyecto,"
					+" id_tipo_componente,"
					+" componente,"					
					+" monto_componente_viable, "
					+" observacion,"				
					+" usuario," 
					+" fecha_registro) values "
					+ "(?,?,?,?,?,?,sysdate())";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proyecto());
			pstm.setInt(2, o.getId_tipo_componente());
			pstm.setString(3, o.getComponente());			
			pstm.setDouble(4, o.getMonto_componente_viable());				
			pstm.setString(5, o.getObservacion());
			pstm.setString(6, o.getUsuario());
			
			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void Eliminar(Componentes o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();

			String sql = " update componentes set activo = 0, fecha_ultima_modificacion = sysdate() where id_componente = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_componente());

			pstm.executeUpdate();

			pstm.close();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void Modificar(Componentes o) throws Exception {
		Connection cn = null;
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update componentes set "
					+" id_tipo_componente = ?,"	
					+" componente = ?,"					
					+" monto_componente_viable = ?,"
					+" observacion = ?,"
					+" usuario = ?,"				
					+" fecha_ultima_modificacion = sysdate() "
					+" where id_componente = ? and activo = 1";
					
			PreparedStatement pstm = cn.prepareStatement(sql);
		
			pstm.setInt(1, o.getId_tipo_componente());
			pstm.setString(2, o.getComponente());			
			pstm.setDouble(3, o.getMonto_componente_viable());
			pstm.setString(4, o.getObservacion());
			pstm.setString(5, o.getUsuario());	
		
			pstm.setInt(6, o.getId_componente());

			pstm.executeUpdate();

			pstm.close();

			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception exception) {
				exception.printStackTrace();
			}

			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public List<Componentes> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Componentes> Filtrar(Componentes o) throws Exception {
		Connection cn = null;
        List<Componentes> lista = new ArrayList<Componentes>();
        try {
            // conexion a la base de datos
            cn = DataAccess.getConnection();
            //comando sql
            String sql = " select "	
            		+" id_componente,"
					+" id_proyecto,"
					+" componente,"					
					+" monto_componente_viable,"					
					+" usuario "
					+ "from componentes "					
					+" where id_proyecto = ? and activo = 1 order by id_componente asc";
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            // crear parametro y asignar valor
            pstm.setInt(1, o.getId_proyecto());

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

            	Componentes c = new Componentes();
				// asignar valores al objeto r
				c.setId_componente(rs.getInt("id_componente"));
				c.setId_proyecto(rs.getInt("id_proyecto"));
				c.setComponente(rs.getString("componente"));				
				c.setMonto_componente_viable(rs.getDouble("monto_componente_viable"));				
				c.setUsuario(rs.getString("usuario"));
													
				lista.add(c);
            }
            // cerrar cursor
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return lista;
	}

	@Override
	public Componentes Buscar(Componentes o) throws Exception {
		
		Connection cn = null;
        Componentes c = new Componentes();
        
        try {
            cn = DataAccess.getConnection();

            String sql = " select "	
            		+" id_componente,"
					+" id_proyecto,"
					+" id_tipo_componente,"
					+" componente,"					
					+" monto_componente_viable,"
					+" observacion,"					
					+" usuario from componentes "					
					+" where id_componente = ? and activo = 1";;
            // crear statement
            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setInt(1, o.getId_componente());
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

            	c.setId_componente(rs.getInt("id_componente"));
				c.setId_proyecto(rs.getInt("id_proyecto"));
				c.setId_tipo_componente(rs.getInt("id_tipo_componente"));
				c.setComponente(rs.getString("componente"));				
				c.setMonto_componente_viable(rs.getDouble("monto_componente_viable"));
				c.setObservacion(rs.getString("observacion"));	
				c.setUsuario(rs.getString("usuario"));    				                

            }
            
            rs.close();
            pstm.close();
            
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return c;
	}

}
