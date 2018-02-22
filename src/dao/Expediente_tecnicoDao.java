package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Expediente_tecnico;

public class Expediente_tecnicoDao implements Intermetodos<Expediente_tecnico> {

	@Override
	public void Grabar(Expediente_tecnico o) throws Exception {
		Connection cn = null;
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " insert into expediente_tecnico("
					+" id_proyecto, "
					+" id_item_proyecto,"
					+" item_descripcion,"
					+ "id_tipo_informe_tecnico,"
					+" informe_tecnico_modificaciones_etapa_inversion,"
					+" monto_informe_tecnico_etapa_inversion," 
					+" fecha_informe_tecnico_etapa_inversion,"
					+" numero_proceso_expediente_tecnico, "
					+" valor_referencial, "
					+" modalidad_contratacion," 
					+" fecha_presupuesto_base,"
					+" postores, "
					+" monto_adjudicado," 
					+" contratista_adjudicado," 
					+" ruc_contratista_adjudicado," 
					+" fecha_otorgamiento," 
					+" numero_contrato," 
					+" fecha_firma_contrato," 
					+" plazo_ejecucion_expediente_tecnico," 
					+" tipo_ejecucion," 
					+" observaciones," 
					+" usuario," 
					+" fecha_registro) values "
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate())";
			
			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proyecto());
			pstm.setInt(2, o.getId_item_proyecto());
			pstm.setString(3, o.getItem_descripcion());
			pstm.setInt(4, o.getId_tipo_informe_tecnico());
			pstm.setString(5, o.getInforme_tecnico_modificaciones_etapa_inversion());
			pstm.setDouble(6, o.getMonto_informe_tecnico_etapa_inversion());
			pstm.setString(7, o.getFecha_informe_tecnico_etapa_inversion());
			pstm.setString(8, o.getNumero_proceso_expediente_tecnico());
			pstm.setDouble(9, o.getValor_referencial());
			pstm.setString(10, o.getModalidad_contratacion());
			pstm.setString(11, o.getFecha_presupuesto_base());
			pstm.setString(12, o.getPostores());
			pstm.setDouble(13, o.getMonto_adjudicado());
			pstm.setString(14, o.getContratista_adjudicado());
			pstm.setString(15, o.getRuc_contratista_adjudicado());
			pstm.setString(16, o.getFecha_otorgamiento());
			pstm.setString(17, o.getNumero_contrato());
			pstm.setString(18, o.getFecha_firma_contrato());
			pstm.setInt(19, o.getPlazo_ejecucion_expediente_tecnico());
			pstm.setString(20, o.getTipo_ejecucion());
			pstm.setString(21, o.getObservaciones());
			pstm.setString(22, o.getUsuario());
			
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
	public void Eliminar(Expediente_tecnico o) throws Exception {
		
		Connection cn = null;
		
		try {
			cn = DataAccess.getConnection();

			String sql = " update expediente_tecnico set activo = 0, fecha_ultima_modificacion = sysdate() where id_expediente_tecnico = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_expediente_tecnico());

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
	public void Modificar(Expediente_tecnico o) throws Exception {
		
		Connection cn = null;
		
		try {
			
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			
			String sql = " update expediente_tecnico set "
					+ "id_item_proyecto = ?,"
					+ "item_descripcion = ?,"
					+ "id_tipo_informe_tecnico = ?,"				
					+" informe_tecnico_modificaciones_etapa_inversion = ?,"
					+" monto_informe_tecnico_etapa_inversion = ?," 
					+" fecha_informe_tecnico_etapa_inversion = ?,"
					+" numero_proceso_expediente_tecnico = ?,"
					+" valor_referencial = ?, "
					+" modalidad_contratacion = ?," 
					+" fecha_presupuesto_base = ?,"
					+" postores = ?, "
					+" monto_adjudicado = ?," 
					+" contratista_adjudicado = ?," 
					+" ruc_contratista_adjudicado = ?," 
					+" fecha_otorgamiento = ?," 
					+" numero_contrato = ?," 
					+" fecha_firma_contrato = ?," 
					+" plazo_ejecucion_expediente_tecnico = ?," 
					+" tipo_ejecucion = ?," 
					+" observaciones = ?,"
					+ " usuario = ?," 				
					+" fecha_ultima_modificacion = sysdate() "
					+ " where id_expediente_tecnico = ? and activo = 1";
					
			PreparedStatement pstm = cn.prepareStatement(sql);
		
			pstm.setInt(1, o.getId_item_proyecto());
			pstm.setString(2, o.getItem_descripcion());
			pstm.setInt(3, o.getId_tipo_informe_tecnico());
			pstm.setString(4, o.getInforme_tecnico_modificaciones_etapa_inversion());
			pstm.setDouble(5, o.getMonto_informe_tecnico_etapa_inversion());
			pstm.setString(6, o.getFecha_informe_tecnico_etapa_inversion());
			pstm.setString(7, o.getNumero_proceso_expediente_tecnico());
			pstm.setDouble(8, o.getValor_referencial());
			pstm.setString(9, o.getModalidad_contratacion());
			pstm.setString(10, o.getFecha_presupuesto_base());
			pstm.setString(11, o.getPostores());
			pstm.setDouble(12, o.getMonto_adjudicado());
			pstm.setString(13, o.getContratista_adjudicado());
			pstm.setString(14, o.getRuc_contratista_adjudicado());
			pstm.setString(15, o.getFecha_otorgamiento());
			pstm.setString(16, o.getNumero_contrato());
			pstm.setString(17, o.getFecha_firma_contrato());
			pstm.setInt(18, o.getPlazo_ejecucion_expediente_tecnico());
			pstm.setString(19, o.getTipo_ejecucion());
			pstm.setString(20, o.getObservaciones());
			pstm.setString(21, o.getUsuario());	
			
			pstm.setInt(22, o.getId_expediente_tecnico());

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
	public List<Expediente_tecnico> Listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Expediente_tecnico> Filtrar(Expediente_tecnico o) throws Exception {
		 Connection cn = null;
	        List<Expediente_tecnico> lista = new ArrayList<Expediente_tecnico>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql = " select "
	            		+" id_expediente_tecnico,"
						+" id_proyecto,"
						+ "id_item_proyecto,"
						+ "item_descripcion,"
						+" informe_tecnico_modificaciones_etapa_inversion,"
						+" monto_informe_tecnico_etapa_inversion," 
						+" date_format(fecha_informe_tecnico_etapa_inversion, '%m/%d/%Y') as fecha_informe_tecnico_etapa_inversion,"
						+" numero_proceso_expediente_tecnico,"
						+" valor_referencial,"
						+" modalidad_contratacion," 
						+" date_format(fecha_presupuesto_base, '%m/%d/%Y') as fecha_presupuesto_base,"
						+" postores,"
						+" monto_adjudicado," 
						+" contratista_adjudicado," 
						+" ruc_contratista_adjudicado," 
						+" date_format(fecha_otorgamiento, '%m/%d/%Y') as fecha_otorgamiento," 
						+" numero_contrato," 
						+" date_format(fecha_firma_contrato, '%m/%d/%Y') as fecha_firma_contrato," 
						+" plazo_ejecucion_expediente_tecnico," 
						+" tipo_ejecucion," 
						+" observaciones," 
						+" usuario "
						+" from expediente_tecnico "
						+" where id_proyecto = ? and activo = 1 order by id_expediente_tecnico asc";
	            // crear statement
	            PreparedStatement pstm = cn.prepareStatement(sql);
	            // crear parametro y asignar valor
	            pstm.setInt(1, o.getId_proyecto());

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Expediente_tecnico et = new Expediente_tecnico();
					// asignar valores al objeto r
					et.setId_expediente_tecnico(rs.getInt("id_expediente_tecnico"));
					et.setId_proyecto(rs.getInt("id_proyecto"));
					et.setId_item_proyecto(rs.getInt("id_item_proyecto"));
					et.setItem_descripcion(rs.getString("item_descripcion"));
					et.setInforme_tecnico_modificaciones_etapa_inversion(rs.getString("informe_tecnico_modificaciones_etapa_inversion"));
					et.setMonto_informe_tecnico_etapa_inversion(rs.getDouble("monto_informe_tecnico_etapa_inversion"));
					et.setFecha_informe_tecnico_etapa_inversion(rs.getString("fecha_informe_tecnico_etapa_inversion"));
					et.setNumero_proceso_expediente_tecnico(rs.getString("numero_proceso_expediente_tecnico"));
					et.setValor_referencial(rs.getDouble("valor_referencial"));
					et.setModalidad_contratacion(rs.getString("modalidad_contratacion"));
					et.setFecha_presupuesto_base(rs.getString("fecha_presupuesto_base"));
					et.setPostores(rs.getString("postores"));
					et.setMonto_adjudicado(rs.getDouble("monto_adjudicado"));
					et.setContratista_adjudicado(rs.getString("contratista_adjudicado"));
					et.setRuc_contratista_adjudicado(rs.getString("ruc_contratista_adjudicado"));
					et.setFecha_otorgamiento(rs.getString("fecha_otorgamiento"));
					et.setNumero_contrato(rs.getString("numero_contrato"));
					et.setFecha_firma_contrato(rs.getString("fecha_firma_contrato"));
					et.setPlazo_ejecucion_expediente_tecnico(rs.getInt("plazo_ejecucion_expediente_tecnico"));
					et.setTipo_ejecucion(rs.getString("tipo_ejecucion"));
					et.setObservaciones(rs.getString("observaciones"));
					et.setUsuario(rs.getString("usuario"));
										
					lista.add(et);
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
	public Expediente_tecnico Buscar(Expediente_tecnico o) throws Exception {
				
		 	Connection cn = null;
		 	
	        Expediente_tecnico et = new Expediente_tecnico();
	        
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select "
	            		+" id_expediente_tecnico,"
						+" id_proyecto,"
						+" id_item_proyecto,"
						+" id_tipo_informe_tecnico,"
						+" informe_tecnico_modificaciones_etapa_inversion,"
						+" monto_informe_tecnico_etapa_inversion," 
						+" date_format(fecha_informe_tecnico_etapa_inversion, '%m/%d/%Y') as fecha_informe_tecnico_etapa_inversion,"
						+" numero_proceso_expediente_tecnico,"
						+" valor_referencial,"
						+" modalidad_contratacion," 
						+" date_format(fecha_presupuesto_base, '%m/%d/%Y') as fecha_presupuesto_base,"
						+" postores,"
						+" monto_adjudicado," 
						+" contratista_adjudicado," 
						+" ruc_contratista_adjudicado," 
						+" date_format(fecha_otorgamiento, '%m/%d/%Y') as  fecha_otorgamiento," 
						+" numero_contrato," 
						+" date_format(fecha_firma_contrato, '%m/%d/%Y') as fecha_firma_contrato," 
						+" plazo_ejecucion_expediente_tecnico," 
						+" tipo_ejecucion," 
						+" observaciones," 
						+" usuario"
						+" from expediente_tecnico "
						+" where id_expediente_tecnico = ? and activo = 1";
	            // crear statement
	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setInt(1, o.getId_expediente_tecnico());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	et.setId_expediente_tecnico(rs.getInt("id_expediente_tecnico"));
					et.setId_proyecto(rs.getInt("id_proyecto"));
					et.setId_item_proyecto(rs.getInt("id_item_proyecto"));
					et.setId_tipo_informe_tecnico(rs.getInt("id_tipo_informe_tecnico"));
					et.setInforme_tecnico_modificaciones_etapa_inversion(rs.getString("informe_tecnico_modificaciones_etapa_inversion"));
					et.setMonto_informe_tecnico_etapa_inversion(rs.getDouble("monto_informe_tecnico_etapa_inversion"));
					et.setFecha_informe_tecnico_etapa_inversion(rs.getString("fecha_informe_tecnico_etapa_inversion"));
					et.setNumero_proceso_expediente_tecnico(rs.getString("numero_proceso_expediente_tecnico"));
					et.setValor_referencial(rs.getDouble("valor_referencial"));
					et.setModalidad_contratacion(rs.getString("modalidad_contratacion"));
					et.setFecha_presupuesto_base(rs.getString("fecha_presupuesto_base"));
					et.setPostores(rs.getString("postores"));
					et.setMonto_adjudicado(rs.getDouble("monto_adjudicado"));
					et.setContratista_adjudicado(rs.getString("contratista_adjudicado"));
					et.setRuc_contratista_adjudicado(rs.getString("ruc_contratista_adjudicado"));
					et.setFecha_otorgamiento(rs.getString("fecha_otorgamiento"));
					et.setNumero_contrato(rs.getString("numero_contrato"));
					et.setFecha_firma_contrato(rs.getString("fecha_firma_contrato"));
					et.setPlazo_ejecucion_expediente_tecnico(rs.getInt("plazo_ejecucion_expediente_tecnico"));
					et.setTipo_ejecucion(rs.getString("tipo_ejecucion"));
					et.setObservaciones(rs.getString("observaciones"));
					et.setUsuario(rs.getString("usuario"));	    				                

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
	        return et;
	        	
	}

}
