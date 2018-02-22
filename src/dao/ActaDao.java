package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Acta;

public class ActaDao implements Intermetodos<Acta> {

	@Override
	public void Grabar(Acta o) throws Exception {
	
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
		
			String sql = " insert into acta ( "
					+ "id_contrato_proceso_seleccion_item, "
					+ "acta_descripcion, "
					+ "fecha_acta, "
					+ "detalle_acta, "
					+ "motivo_generado, "
					+ "usuario,"
					+ "fecha_registro, "			
					+ "activo) "
					+ " values(?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getActa_descripcion());	
			pstm.setString(3, o.getFecha_acta());
			pstm.setString(4, o.getDetalle_acta());
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
	public void Eliminar(Acta o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update acta set activo = 0, fecha_ultima_modificacion = sysdate() where id_acta = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_acta());
			
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
	public void Modificar(Acta o) throws Exception {
		Connection cn = null;
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update acta  set "					
					+ " acta_descripcion = ?, "				
					+ " fecha_acta = ?, "
					+ " detalle_acta = ?, "
					+ " motivo_generado = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_acta = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getActa_descripcion());
			pstm.setString(2, o.getFecha_acta());
			pstm.setString(3, o.getDetalle_acta());
			pstm.setString(4, o.getMotivo_generado());
			pstm.setString(5, o.getUsuario());
						
			pstm.setInt(6, o.getId_acta());

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
	public List<Acta> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acta> Filtrar(Acta o) throws Exception {
		
		 Connection cn = null;
	        List<Acta> lista = new ArrayList<Acta>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " id_acta,"
	            		+ " id_contrato_proceso_seleccion_item, "
	            		+ " acta_descripcion, "
	            		+ " fecha_acta, "
	            		+ " detalle_acta, "
	            		+ " motivo_generado, "
	            		+ " usuario "	            		 
	            		+ " from acta "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_acta asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Acta a = new Acta();
		
					a.setId_acta(rs.getInt("id_acta"));
					a.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					a.setActa_descripcion(rs.getString("acta_descripcion"));
					a.setFecha_acta(rs.getString("fecha_acta"));
					a.setDetalle_acta(rs.getString("detalle_acta"));
					a.setMotivo_generado(rs.getString("motivo_generado"));								
					a.setUsuario(rs.getString("usuario"));

					lista.add(a);
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
	public Acta Buscar(Acta o) throws Exception {
		 Connection cn = null;
	        Acta a = new Acta();
	        try {
	            cn = DataAccess.getConnection();
	      
	            String sql = " select "
	            		+ " id_acta, "
	            		+ " acta_descripcion,"
	            		+ " date_format(fecha_acta, '%m/%d/%Y') as fecha_acta, "
	            		+ " detalle_acta, "	            		
	            		+ " motivo_generado "	            		
	            		+ " from acta "
	            		+ " where id_acta = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_acta());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	a.setId_acta(rs.getInt("id_acta"));
	            	a.setActa_descripcion(rs.getString("acta_descripcion"));
	            	a.setFecha_acta(rs.getString("fecha_acta"));
	            	a.setDetalle_acta(rs.getString("detalle_acta"));
	            	a.setMotivo_generado(rs.getString("motivo_generado"));
	            	
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
	        return a;
	}
	
}
