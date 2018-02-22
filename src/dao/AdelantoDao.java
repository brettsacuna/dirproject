package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Adelanto;

public class AdelantoDao implements Intermetodos<Adelanto>{

	@Override
	public void Grabar(Adelanto o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into adelanto ( "
					+ "id_contrato_proceso_seleccion_item, "
					+ "adelanto_descipcion, "
					+ "fecha_solicitud_adelanto, "
					+ "tipo_adelanto, "
					+ "monto_adelanto, "
					+ "usuario,"
					+ "fecha_registro, "			
					+ "activo) "
					+ " values(?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getAdelanto_descipcion());	
			pstm.setString(3, o.getFecha_solicitud_adelanto());
			pstm.setString(4, o.getTipo_adelanto());
			pstm.setDouble(5, o.getMonto_adelanto());		
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
	public void Eliminar(Adelanto o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update adelanto set activo = 0, fecha_ultima_modificacion = sysdate() where id_adelanto = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_adelanto());
			
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
	public void Modificar(Adelanto o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update adelanto  set "					
					+ " adelanto_descipcion = ?, "				
					+ " fecha_solicitud_adelanto = ?, "
					+ " tipo_adelanto = ?, "
					+ " monto_adelanto = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_adelanto = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getAdelanto_descipcion());
			pstm.setString(2, o.getFecha_solicitud_adelanto());
			pstm.setString(3, o.getTipo_adelanto());
			pstm.setDouble(4, o.getMonto_adelanto());
			pstm.setString(5, o.getUsuario());
						
			pstm.setInt(6, o.getId_adelanto());

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
	public List<Adelanto> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adelanto> Filtrar(Adelanto o) throws Exception {
		 Connection cn = null;
	        List<Adelanto> lista = new ArrayList<Adelanto>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " id_adelanto,"
	            		+ " id_contrato_proceso_seleccion_item, "
	            		+ " adelanto_descipcion, "
	            		+ " fecha_solicitud_adelanto, "
	            		+ " tipo_adelanto, "
	            		+ " monto_adelanto, "
	            		+ " usuario "	            		 
	            		+ " from adelanto "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_adelanto asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Adelanto ad = new Adelanto();
		
					ad.setId_adelanto(rs.getInt("id_adelanto"));
					ad.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					ad.setAdelanto_descipcion(rs.getString("adelanto_descipcion"));
					ad.setFecha_solicitud_adelanto(rs.getString("fecha_solicitud_adelanto"));
					ad.setTipo_adelanto(rs.getString("tipo_adelanto"));
					ad.setMonto_adelanto(rs.getDouble("monto_adelanto"));								
					ad.setUsuario(rs.getString("usuario"));

					lista.add(ad);
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
	public Adelanto Buscar(Adelanto o) throws Exception {
		 Connection cn = null;
	        Adelanto ad = new Adelanto();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_adelanto, "
	            		+ " adelanto_descipcion,"
	            		+ " date_format(fecha_solicitud_adelanto, '%m/%d/%Y') as fecha_solicitud_adelanto, "
	            		+ " tipo_adelanto, "	            		
	            		+ " monto_adelanto "	            		
	            		+ " from adelanto "
	            		+ " where id_adelanto = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_adelanto());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	ad.setId_adelanto(rs.getInt("id_adelanto"));
	            	ad.setAdelanto_descipcion(rs.getString("adelanto_descipcion"));
	            	ad.setFecha_solicitud_adelanto(rs.getString("fecha_solicitud_adelanto"));
	            	ad.setTipo_adelanto(rs.getString("tipo_adelanto"));
	            	ad.setMonto_adelanto(rs.getDouble("monto_adelanto"));
	            	
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
	        return ad;
	
	}

}
