package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Otros_documentos;

public class Otros_documentosDao implements Intermetodos<Otros_documentos> {

	@Override
	public void Grabar(Otros_documentos o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " insert into otros_documentos("
					+ " id_contrato_proceso_seleccion_item,"
					+ " informacion_especifica, "
					+ " fecha_informe, "
					+ " detalle,"
					+ " motivo_generado,"
					+ " usuario,"
					+ " fecha_registro,"					
					+ " activo)"
					+ "values(?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getInformacion_especifica());
			pstm.setString(3, o.getFecha_informe());
			pstm.setString(4, o.getDetalle());
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
	public void Eliminar(Otros_documentos o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update otros_documentos set activo = 0, fecha_ultima_modificacion = sysdate() where id_otro_documento = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_otro_documento());
			
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
	public void Modificar(Otros_documentos o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update otros_documentos  set "				
					+ " informacion_especifica = ?, "
					+ " fecha_informe = ?, "
					+ " detalle = ?,"
					+ " motivo_generado = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_otro_documento = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getInformacion_especifica());
			pstm.setString(2, o.getFecha_informe());
			pstm.setString(3, o.getDetalle());
			pstm.setString(4, o.getMotivo_generado());
			pstm.setString(5, o.getUsuario());
			
			pstm.setInt(6, o.getId_otro_documento());
			

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
	public List<Otros_documentos> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Otros_documentos> Filtrar(Otros_documentos o) throws Exception {
		 Connection cn = null;
	        List<Otros_documentos> lista = new ArrayList<Otros_documentos>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " id_otro_documento, "
	            		+ " id_contrato_proceso_seleccion_item,"
						+ " informacion_especifica, "
						+ " fecha_informe, "
						+ " detalle,"
						+ " motivo_generado,"						
	            		+ " usuario "
	            		+ "   from otros_documentos "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_otro_documento asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
	           
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Otros_documentos od = new Otros_documentos();
		
					od.setId_otro_documento(rs.getInt("id_otro_documento"));
					od.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					od.setInformacion_especifica(rs.getString("informacion_especifica"));
					od.setFecha_informe(rs.getString("fecha_informe"));
					od.setDetalle(rs.getString("detalle"));
					od.setMotivo_generado(rs.getString("motivo_generado"));
					
					od.setUsuario(rs.getString("usuario"));
					
				
					lista.add(od);
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
	        return lista;
	}

	@Override
	public Otros_documentos Buscar(Otros_documentos o) throws Exception {
		
		 Connection cn = null;
		 
	        Otros_documentos od = new Otros_documentos();
	        
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_otro_documento, "	            	
						+ " informacion_especifica, "
						+ " date_format(fecha_informe, '%m/%d/%Y') as fecha_informe, "
						+ " detalle,"
						+ " motivo_generado "		
	            		+ " 	from otros_documentos "
	            		+ " where id_otro_documento = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_otro_documento());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	od.setId_otro_documento(rs.getInt("id_otro_documento"));					
					od.setInformacion_especifica(rs.getString("informacion_especifica"));
					od.setFecha_informe(rs.getString("fecha_informe"));
					od.setDetalle(rs.getString("detalle"));
					od.setMotivo_generado(rs.getString("motivo_generado"));
					

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
	        return od;
	}
	
}
