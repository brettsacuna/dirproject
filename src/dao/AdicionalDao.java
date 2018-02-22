package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Adicional;


public class AdicionalDao implements Intermetodos<Adicional>{

	@Override
	public void Grabar(Adicional o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into adicional("
					+ " id_contrato_proceso_seleccion_item, "
					+ "resolucion_aprobacion_adicional, "
					+ "fecha_resolucion_aprobacion_adicional,"
					+ " monto_adicional_otorgado, "
					+ "motivo_generado, "
					+ "usuario, "
					+ "fecha_registro,"			
					+ "activo) "
					+ "values(?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getResolucion_aprobacion_adicional());	
			pstm.setString(3, o.getFecha_resolucion_aprobacion_adicional());
			pstm.setDouble(4, o.getMonto_adicional_otorgado());
			pstm.setString(5, o.getMotivo_generado());
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
	public void Eliminar(Adicional o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			
			cn.setAutoCommit(false);
			
			String sql = " update adicional set activo = 0, fecha_ultima_modificacion = sysdate() where id_adicional = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_adicional());
			
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
	public void Modificar(Adicional o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update adicional  set "					
					+ " resolucion_aprobacion_adicional = ?, "
					+ " fecha_resolucion_aprobacion_adicional = ?, "
					+ " monto_adicional_otorgado = ?, "
					+ " motivo_generado = ?,"
					+ " usuario = ?, "					
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_adicional = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getResolucion_aprobacion_adicional());
			pstm.setString(2, o.getFecha_resolucion_aprobacion_adicional());
			pstm.setDouble(3, o.getMonto_adicional_otorgado());
			pstm.setString(4, o.getMotivo_generado());
			pstm.setString(5, o.getUsuario());
			
			pstm.setInt(6, o.getId_adicional());
			
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
	public List<Adicional> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adicional> Filtrar(Adicional o) throws Exception {
		 Connection cn = null;
	        List<Adicional> lista = new ArrayList<Adicional>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " id_adicional,"
	            		+ " id_contrato_proceso_seleccion_item, "
						+ " resolucion_aprobacion_adicional, "
						+ " fecha_resolucion_aprobacion_adicional,"
						+ " monto_adicional_otorgado, "
						+ " motivo_generado, "
						+ " usuario "	            		 
	            		+ " from adicional "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_adicional asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Adicional ad = new Adicional();
		
					ad.setId_adicional(rs.getInt("id_adicional"));
					ad.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					ad.setResolucion_aprobacion_adicional(rs.getString("resolucion_aprobacion_adicional"));
					ad.setFecha_resolucion_aprobacion_adicional(rs.getString("fecha_resolucion_aprobacion_adicional"));
					ad.setMonto_adicional_otorgado(rs.getDouble("monto_adicional_otorgado"));
					ad.setMotivo_generado(rs.getString("motivo_generado"));						
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
	public Adicional Buscar(Adicional o) throws Exception {
		 Connection cn = null;
	        Adicional ad = new Adicional();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_adicional,"
	            		+ " resolucion_aprobacion_adicional,"
	            		+ " date_format(fecha_resolucion_aprobacion_adicional, '%m/%d/%Y') as fecha_resolucion_aprobacion_adicional, "
	            		+ " monto_adicional_otorgado, "
	            		+ " motivo_generado "	            		
	            		+ " from adicional "
	            		+ " where id_adicional = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_adicional());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	ad.setId_adicional(rs.getInt("id_adicional"));
	            	ad.setResolucion_aprobacion_adicional(rs.getString("resolucion_aprobacion_adicional"));
	            	ad.setFecha_resolucion_aprobacion_adicional(rs.getString("fecha_resolucion_aprobacion_adicional"));
	            	ad.setMonto_adicional_otorgado(rs.getDouble("monto_adicional_otorgado"));
	            	ad.setMotivo_generado(rs.getString("motivo_generado"));
	            	
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
