package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Ampliacion_plazo;

public class Ampliacion_plazoDao implements Intermetodos<Ampliacion_plazo> {

	@Override
	public void Grabar(Ampliacion_plazo o) throws Exception {
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into ampliacion_plazo( "					
					+ " id_contrato_proceso_seleccion_item, "
					+ " resolucion_aprobacion_ampliacion_plazo, "
					+ " fecha_resolucion_aprobacion_ampliacion_plazo,  "
					+ " plazo_otorgado, "
					+ " motivo_generado, "
					+ " usuario, "
					+ " fecha_registro, "		
					+ " activo ) "
					+ " values(?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getResolucion_aprobacion_ampliacion_plazo());	
			pstm.setString(3, o.getFecha_resolucion_aprobacion_ampliacion_plazo());
			pstm.setInt(4, o.getPlazo_otorgado());
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
	public void Eliminar(Ampliacion_plazo o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update ampliacion_plazo set activo = 0, fecha_ultima_modificacion = sysdate() where id_ampliacion_plazo = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_ampliacion_plazo());
			
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
	public void Modificar(Ampliacion_plazo o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			
			cn.setAutoCommit(false);
			
			String sql = " update ampliacion_plazo  set "					
					+ " resolucion_aprobacion_ampliacion_plazo = ?, "
					+ " fecha_resolucion_aprobacion_ampliacion_plazo = ?, "					
					+ " plazo_otorgado = ?, "
					+ " motivo_generado = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_ampliacion_plazo = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getResolucion_aprobacion_ampliacion_plazo());
			pstm.setString(2, o.getFecha_resolucion_aprobacion_ampliacion_plazo());
			pstm.setInt(3, o.getPlazo_otorgado());
			pstm.setString(4, o.getMotivo_generado());
			pstm.setString(5, o.getUsuario());
			
			pstm.setInt(6, o.getId_ampliacion_plazo());
			
			

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
	public List<Ampliacion_plazo> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ampliacion_plazo> Filtrar(Ampliacion_plazo o) throws Exception {
		 Connection cn = null;
	        List<Ampliacion_plazo> lista = new ArrayList<Ampliacion_plazo>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " id_ampliacion_plazo,"
	            		+ " id_contrato_proceso_seleccion_item, "
						+ " resolucion_aprobacion_ampliacion_plazo, "
						+ " fecha_resolucion_aprobacion_ampliacion_plazo,  "
						+ " plazo_otorgado, "
						+ " motivo_generado, "
						+ " usuario "	            		 
	            		+ " from ampliacion_plazo "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_ampliacion_plazo asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Ampliacion_plazo ap = new Ampliacion_plazo();
		
					ap.setId_ampliacion_plazo(rs.getInt("id_ampliacion_plazo"));
					ap.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					ap.setResolucion_aprobacion_ampliacion_plazo(rs.getString("resolucion_aprobacion_ampliacion_plazo"));
					ap.setFecha_resolucion_aprobacion_ampliacion_plazo(rs.getString("fecha_resolucion_aprobacion_ampliacion_plazo"));
					ap.setPlazo_otorgado(rs.getInt("plazo_otorgado"));
					ap.setMotivo_generado(rs.getString("motivo_generado"));				
					ap.setUsuario(rs.getString("usuario"));

					lista.add(ap);
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
	public Ampliacion_plazo Buscar(Ampliacion_plazo o) throws Exception {
		
		 Connection cn = null;
		 
	        Ampliacion_plazo ap = new Ampliacion_plazo();
	     
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_ampliacion_plazo,"
	            		+ " resolucion_aprobacion_ampliacion_plazo,"
	            		+ " date_format(fecha_resolucion_aprobacion_ampliacion_plazo, '%m/%d/%Y') as fecha_resolucion_aprobacion_ampliacion_plazo, "
	            		+ " plazo_otorgado, "
	            		+ " motivo_generado "
	            		+ " from ampliacion_plazo "
	            		+ " where id_ampliacion_plazo = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_ampliacion_plazo());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	ap.setId_ampliacion_plazo(rs.getInt("id_ampliacion_plazo"));
	            	ap.setResolucion_aprobacion_ampliacion_plazo(rs.getString("resolucion_aprobacion_ampliacion_plazo"));
	            	ap.setFecha_resolucion_aprobacion_ampliacion_plazo(rs.getString("fecha_resolucion_aprobacion_ampliacion_plazo"));
	            	ap.setPlazo_otorgado(rs.getInt("plazo_otorgado"));
	            	ap.setMotivo_generado(rs.getString("motivo_generado"));
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
	        return ap;
		
	}

}
