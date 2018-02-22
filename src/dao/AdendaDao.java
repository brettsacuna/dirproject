package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Adenda;

public class AdendaDao implements Intermetodos<Adenda> {

	@Override
	public void Grabar(Adenda o) throws Exception {
	Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();			
			cn.setAutoCommit(false);
			
			String sql = " insert into adenda("
					+ "id_contrato_proceso_seleccion_item, "
					+ "adenda_descripcion, "
					+ "fecha_suscripcion, "
					+ "plazo_otorgado, "
					+ "motivo_generado, "
					+ "usuario, "
					+ "fecha_registro, "					
					+ "activo) "
					+ "values(?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getAdenda_descripcion());
			pstm.setString(3, o.getFecha_suscripcion());
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
	public void Eliminar(Adenda o) throws Exception {

		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update adenda set activo = 0, fecha_ultima_modificacion = sysdate() where id_adenda = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_adenda());
			
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
	public void Modificar(Adenda o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update adenda  set "					
					+ " adenda_descripcion = ?, "
					+ " fecha_suscripcion = ?, "					
					+ " plazo_otorgado = ?, "
					+ " motivo_generado = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate() "
					+ " where id_adenda = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getAdenda_descripcion());
			pstm.setString(2, o.getFecha_suscripcion());
			pstm.setInt(3, o.getPlazo_otorgado());
			pstm.setString(4, o.getMotivo_generado());
			pstm.setString(5, o.getUsuario());
			
			pstm.setInt(6, o.getId_adenda());
			
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
	public List<Adenda> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adenda> Filtrar(Adenda o) throws Exception {
		 Connection cn = null;
	        List<Adenda> lista = new ArrayList<Adenda>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ "id_adenda,"
	            		+ "id_contrato_proceso_seleccion_item, "
						+ "adenda_descripcion, "
						+ "fecha_suscripcion, "
						+ "plazo_otorgado, "
						+ "motivo_generado, "
						+ "usuario " 
	            		+ " from adenda "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_adenda asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Adenda a = new Adenda();
		
					a.setId_adenda(rs.getInt("id_adenda"));
					a.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					a.setAdenda_descripcion(rs.getString("adenda_descripcion"));
					a.setFecha_suscripcion(rs.getString("fecha_suscripcion"));
					a.setPlazo_otorgado(rs.getInt("plazo_otorgado"));
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
	public Adenda Buscar(Adenda o) throws Exception {
		 Connection cn = null;
	        Adenda a = new Adenda();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_adenda,"
	            		+ " adenda_descripcion,"
	            		+ " date_format(fecha_suscripcion, '%m/%d/%Y') as fecha_suscripcion, "
	            		+ " plazo_otorgado, "
	            		+ " motivo_generado "	            		
	            		+ " from adenda "
	            		+ " where id_adenda = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_adenda());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	a.setId_adenda(rs.getInt("id_adenda"));
	            	a.setAdenda_descripcion(rs.getString("adenda_descripcion"));
	            	a.setFecha_suscripcion(rs.getString("fecha_suscripcion"));
	            	a.setPlazo_otorgado(rs.getInt("plazo_otorgado"));
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
