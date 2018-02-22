package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Garantia;

public class GarantiaDao implements Intermetodos<Garantia> {

	@Override
	public void Grabar(Garantia o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " insert into garantia("
					+ " id_contrato_proceso_seleccion_item, "
					+ "descripcion_garantia, "
					+ "factura, "
					+ "fecha_factura, "
					+ "tipo_garantia, "
					+ "institucion_financiera, "
					+ "numero_documento,"
					+ "monto_adelanto, "
					+ "monto_carta_fianza, "
					+ "fecha_creacion, "
					+ "fecha_vencimiento, "
					+ "usuario, "
					+ "fecha_registro, "					
					+ "activo) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate(),1)";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
			pstm.setString(2, o.getDescripcion_garantia());
			pstm.setString(3, o.getFactura());
			pstm.setString(4, o.getFecha_factura());
			pstm.setString(5, o.getTipo_garantia());
			pstm.setString(6, o.getInstitucion_financiera());
			pstm.setString(7, o.getNumero_documento());
			pstm.setDouble(8, o.getMonto_adelanto());
			pstm.setDouble(9, o.getMonto_carta_fianza());
			pstm.setString(10, o.getFecha_creacion());
			pstm.setString(11, o.getFecha_vencimiento());
			pstm.setString(12, o.getUsuario());
			
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
	public void Eliminar(Garantia o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update garantia set activo = 0, fecha_ultima_modificacion = sysdate() where id_garantia = ? ";				
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_garantia());
			
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
	public void Modificar(Garantia o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update garantia  set "				
					+ "descripcion_garantia = ?, "
					+ "factura = ?, "
					+ "fecha_factura = ?, "
					+ "tipo_garantia = ?, "
					+ "institucion_financiera = ?, "
					+ "numero_documento = ?,"
					+ "monto_adelanto = ?, "
					+ "monto_carta_fianza = ?, "
					+ "fecha_creacion = ?, "
					+ "fecha_vencimiento = ?,"
					+ " usuario = ?, "
					+ " fecha_ultima_modificacion = sysdate()"
					+ " where id_garantia = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getDescripcion_garantia());
			pstm.setString(2, o.getFactura());
			pstm.setString(3, o.getFecha_factura());
			pstm.setString(4, o.getTipo_garantia());
			pstm.setString(5, o.getInstitucion_financiera());
			pstm.setString(6, o.getNumero_documento());
			pstm.setDouble(7, o.getMonto_adelanto());
			pstm.setDouble(8, o.getMonto_carta_fianza());
			pstm.setString(9, o.getFecha_creacion());
			pstm.setString(10, o.getFecha_vencimiento());
			pstm.setString(11, o.getUsuario());
						
			pstm.setInt(12, o.getId_garantia());

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
	public List<Garantia> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Garantia> Filtrar(Garantia o) throws Exception {
		 Connection cn = null;
	        List<Garantia> lista = new ArrayList<Garantia>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql ="select "
	            		+ " id_garantia, "
	            		+ " id_contrato_proceso_seleccion_item, "
	            		+ " descripcion_garantia, "
	            		+ " factura, "
	            		+ " fecha_factura, "
	            		+ " tipo_garantia, "
	            		+ " institucion_financiera, "
	            		+ " numero_documento, "
	            		+ " monto_adelanto, "
	            		+ " monto_carta_fianza, "
	            		+ " fecha_creacion, "
	            		+ " fecha_vencimiento, "
	            		+ " usuario "
	            		+ "   from garantia "
	            		+ " where id_contrato_proceso_seleccion_item = ? "
	            		+ " and activo = 1 order by id_garantia asc";
	       
	            PreparedStatement pstm = cn.prepareStatement(sql);
	        
	            pstm.setInt(1, o.getId_contrato_proceso_seleccion_item());
	           
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Garantia g = new Garantia();
		
					g.setId_garantia(rs.getInt("id_garantia"));
					g.setId_contrato_proceso_seleccion_item(rs.getInt("id_contrato_proceso_seleccion_item"));
					g.setDescripcion_garantia(rs.getString("descripcion_garantia"));
					g.setFactura(rs.getString("factura"));
					g.setFecha_factura(rs.getString("fecha_factura"));
					g.setTipo_garantia(rs.getString("tipo_garantia"));
					g.setInstitucion_financiera(rs.getString("institucion_financiera"));
					g.setNumero_documento(rs.getString("numero_documento"));
					g.setMonto_adelanto(rs.getDouble("monto_adelanto"));
					g.setMonto_carta_fianza(rs.getDouble("monto_carta_fianza"));
					g.setFecha_creacion(rs.getString("fecha_creacion"));
					g.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
					g.setUsuario(rs.getString("usuario"));
					
				
					lista.add(g);
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
	public Garantia Buscar(Garantia o) throws Exception {
		 Connection cn = null;
	        Garantia g = new Garantia();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+ " id_garantia, "	            		
	            		+ " descripcion_garantia, "
	            		+ " factura, "
	            		+ " date_format(fecha_factura, '%m/%d/%Y') as  fecha_factura, "
	            		+ " tipo_garantia, "
	            		+ " institucion_financiera, "
	            		+ " numero_documento, "
	            		+ " monto_adelanto, "
	            		+ " monto_carta_fianza, "
	            		+ " date_format(fecha_creacion, '%m/%d/%Y') as fecha_creacion, "
	            		+ " date_format(fecha_vencimiento, '%m/%d/%Y') as fecha_vencimiento "
	            		+ " 	from garantia "
	            		+ " where id_garantia = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_garantia());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	g.setId_garantia(rs.getInt("id_garantia"));					
					g.setDescripcion_garantia(rs.getString("descripcion_garantia"));
					g.setFactura(rs.getString("factura"));
					g.setFecha_factura(rs.getString("fecha_factura"));
					g.setTipo_garantia(rs.getString("tipo_garantia"));
					g.setInstitucion_financiera(rs.getString("institucion_financiera"));
					g.setNumero_documento(rs.getString("numero_documento"));
					g.setMonto_adelanto(rs.getDouble("monto_adelanto"));
					g.setMonto_carta_fianza(rs.getDouble("monto_carta_fianza"));
					g.setFecha_creacion(rs.getString("fecha_creacion"));
					g.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
					

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
	        return g;
	}

}
