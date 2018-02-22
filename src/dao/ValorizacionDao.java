package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Valorizacion;

public class ValorizacionDao implements Intermetodos<Valorizacion>{

	@Override
	public void Grabar(Valorizacion o) throws Exception {
	
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
		
			String sql = " insert into valorizacion ( "
					+ "id_contrato_proceso_seleccion_item,"
					+ "periodo, "
					+ "valorizacion_programada, "
					+ "valorizacion_ejecutada, "
					+ "valorizacion_acumulada, "
					+ "porcentaje_valorizado_acumulado, "
					+ "observacion,"				
					+ "usuario,"
					+ "fecha_registro, "			
					+ "activo) "
					+ " values(?,?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getPeriodo());	
			pstm.setDouble(3, o.getValorizacion_programada());
			pstm.setDouble(4, o.getValorizacion_ejecutada());
			pstm.setDouble(5, o.getValorizacion_acumulada());			
			pstm.setDouble(6, o.getPorcentaje_valorizado_acumulado());
			pstm.setString(7, o.getObservacion());		
			pstm.setString(8, o.getUsuario());
			
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
	public void Eliminar(Valorizacion o) throws Exception {
	
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update valorizacion set activo = 0, fecha_ultima_modificacion = sysdate() where id_valorizacion = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_valorizacion());
			
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
	public void Modificar(Valorizacion o) throws Exception {

		Connection cn = null;
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update valorizacion  set "					
					+ " periodo = ?, "				
					+ " valorizacion_programada = ?, "
					+ " valorizacion_ejecutada = ?,"
					+ " valorizacion_acumulada = ?, "
					+ " porcentaje_valorizado_acumulado = ?,"
					+ " observacion = ?, "
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate() "
					+ " where id_valorizacion = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getPeriodo());
			pstm.setDouble(2, o.getValorizacion_programada());
			pstm.setDouble(3, o.getValorizacion_ejecutada());
			pstm.setDouble(4, o.getValorizacion_acumulada());
			pstm.setDouble(5, o.getPorcentaje_valorizado_acumulado());
			pstm.setString(6, o.getObservacion());
			pstm.setString(7, o.getUsuario());
			
			pstm.setInt(8, o.getId_valorizacion());

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
	
	public void Recalcular_valorizacion(Valorizacion o) throws Exception {

		Connection cn = null;
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update valorizacion  set "				
					+ " valorizacion_acumulada = ?, "
					+ " porcentaje_valorizado_acumulado = ?,"				
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate() "
					+ " where id_valorizacion = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			
			pstm.setDouble(1, o.getValorizacion_acumulada());
			pstm.setDouble(2, o.getPorcentaje_valorizado_acumulado());			
			pstm.setString(3, o.getUsuario());
			
			pstm.setInt(4, o.getId_valorizacion());

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
	public List<Valorizacion> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Valorizacion> Filtrar(Valorizacion o) throws Exception {
	
		 Connection cn = null;
	        List<Valorizacion> lista = new ArrayList<Valorizacion>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql = "select "
	            		+ " id_valorizacion,"
	            		+ " id_contrato_proceso_seleccion_item, "
	            		+ " periodo, "
	            		+ " valorizacion_programada, "
	            		+ " valorizacion_ejecutada,"
	            		+ " valorizacion_acumulada, "
	            		+ " porcentaje_valorizado_acumulado, "
	            		+ " usuario "	            		 
	            		+ " from valorizacion "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_valorizacion,periodo asc;";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Valorizacion v = new Valorizacion();
		
					v.setId_valorizacion(rs.getInt("id_valorizacion"));
					v.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					v.setPeriodo(rs.getString("periodo"));
					v.setValorizacion_programada(rs.getDouble("valorizacion_programada"));
					v.setValorizacion_ejecutada(rs.getDouble("valorizacion_ejecutada"));
					v.setValorizacion_acumulada(rs.getDouble("valorizacion_acumulada"));
					v.setPorcentaje_valorizado_acumulado(rs.getDouble("porcentaje_valorizado_acumulado"));								
					v.setUsuario(rs.getString("usuario"));

					lista.add(v);
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
	public Valorizacion Buscar(Valorizacion o) throws Exception {

		Connection cn = null;
        Valorizacion v = new Valorizacion();
        try {
            cn = DataAccess.getConnection();
      
            String sql = "select "
            		+ " id_valorizacion, "
            		+ " date_format(periodo, '%m/%d/%Y') as periodo,"
            		+ " valorizacion_programada, "
            		+ " valorizacion_ejecutada, "
            		+ " valorizacion_acumulada,"	            		
            		+ " porcentaje_valorizado_acumulado,"
            		+ "	observacion "	            		
            		+ " from valorizacion "
            		+ " where id_valorizacion = ? and activo = 1; ";

            PreparedStatement pstm = cn.prepareStatement(sql);
            
            pstm.setInt(1, o.getId_valorizacion());
            
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {

            	v.setId_valorizacion(rs.getInt("id_valorizacion"));
            	v.setPeriodo(rs.getString("periodo"));
            	v.setValorizacion_programada(rs.getDouble("valorizacion_programada"));
            	v.setValorizacion_ejecutada(rs.getDouble("valorizacion_ejecutada"));
            	v.setValorizacion_acumulada(rs.getDouble("valorizacion_acumulada"));
            	v.setPorcentaje_valorizado_acumulado(rs.getDouble("porcentaje_valorizado_acumulado"));
            	v.setObservacion(rs.getString("observacion"));
            	
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
        return v;
	}
	
}
