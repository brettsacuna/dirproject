package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DataAccess;
import entity.Datos_proyecto;

public class Datos_proyectoDao implements Intermetodos<Datos_proyecto> {

	@Override
	public void Grabar(Datos_proyecto o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " insert into datos_proyecto(codigo_snip, codigo_proyecto, etapa_proyecto, estado_proyecto, "
					+ " ubicacion, nombre_pip, presupuesto_viabilidad, consultor_preinversion, consultor_expediente_tecnico, "
					+ " resolucion_aprobacion_expediente_tecnico, fecha_resolucion_aprobacion_expediente_tecnico, "
					+ " presupuesto_expediente_tecnico, valor_referencial, resolucion_aprobacion_valor_referencial, "
					+ " fecha_resolucion_aprobacion_valor_referencial, resolucion_actualizacion_valor_referencial, "
					+ " fecha_resolucion_actualizacion_valor_referencial, informe_tecnico_declaratoria_viabilidad, "
					+ " fecha_informe_tecnico_declaratoria_viabilidad, beneficiarios_directos, usuario, fecha_registro) "
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate())";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getCodigo_snip());
			pstm.setString(2, o.getCodigo_proyecto());
			pstm.setString(3, o.getEtapa_proyecto());
			pstm.setString(4, o.getEstado_proyecto());
			pstm.setString(5, o.getUbicacion());
			pstm.setString(6, o.getNombre_pip());
			pstm.setDouble(7, o.getPresupuesto_viabilidad());
			pstm.setString(8, o.getConsultor_preinversion());
			pstm.setString(9, o.getConsultor_expediente_tecnico());
			pstm.setString(10, o.getResolucion_aprobacion_expediente_tecnico());
			pstm.setString(11, o.getFecha_resolucion_aprobacion_expediente_tecnico());
			pstm.setDouble(12, o.getPresupuesto_expediente_tecnico());
			pstm.setDouble(13, o.getValor_referencial());
			pstm.setString(14, o.getResolucion_aprobacion_valor_referencial());
			pstm.setString(15, o.getFecha_resolucion_aprobacion_valor_referencial());
			pstm.setString(16, o.getResolucion_actualizacion_valor_referencial());
			pstm.setString(17, o.getFecha_resolucion_actualizacion_valor_referencial());
			pstm.setString(18, o.getInforme_tecnico_declaratoria_viabilidad());
			pstm.setString(19, o.getFecha_informe_tecnico_declaratoria_viabilidad());
			pstm.setString(20, o.getBeneficiarios_directos());
			pstm.setString(21, o.getUsuario());

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
	public void Eliminar(Datos_proyecto o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();

			String sql = " update datos_proyecto set activo = 0, fecha_ultima_modificacion = sysdate() where id_proyecto = ? ";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setInt(1, o.getId_proyecto());

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
	public void Modificar(Datos_proyecto o) throws Exception {
		Connection cn = null;
		try {
			cn = DataAccess.getConnection();
			cn.setAutoCommit(false);
			String sql = " update datos_proyecto set codigo_snip = ?, codigo_proyecto = ?, etapa_proyecto = ?, estado_proyecto = ?, "
					+ " ubicacion = ?, nombre_pip = ?, presupuesto_viabilidad = ?, consultor_preinversion = ?, consultor_expediente_tecnico = ?, "
					+ " resolucion_aprobacion_expediente_tecnico = ?, fecha_resolucion_aprobacion_expediente_tecnico = ?, "
					+ " presupuesto_expediente_tecnico = ?, valor_referencial = ?, resolucion_aprobacion_valor_referencial = ?, "
					+ " fecha_resolucion_aprobacion_valor_referencial = ?, resolucion_actualizacion_valor_referencial = ?, "
					+ " fecha_resolucion_actualizacion_valor_referencial = ?, informe_tecnico_declaratoria_viabilidad = ?, "
					+ " fecha_informe_tecnico_declaratoria_viabilidad = ?, beneficiarios_directos = ?, usuario = ? ,fecha_ultima_modificacion = sysdate() "
					+ " where id_proyecto = ? and activo = 1";

			PreparedStatement pstm = cn.prepareStatement(sql);

			pstm.setString(1, o.getCodigo_snip());
			pstm.setString(2, o.getCodigo_proyecto());
			pstm.setString(3, o.getEtapa_proyecto());
			pstm.setString(4, o.getEstado_proyecto());
			pstm.setString(5, o.getUbicacion());
			pstm.setString(6, o.getNombre_pip());
			pstm.setDouble(7, o.getPresupuesto_viabilidad());
			pstm.setString(8, o.getConsultor_preinversion());
			pstm.setString(9, o.getConsultor_expediente_tecnico());
			pstm.setString(10, o.getResolucion_aprobacion_expediente_tecnico());
			pstm.setString(11, o.getFecha_resolucion_aprobacion_expediente_tecnico());
			pstm.setDouble(12, o.getPresupuesto_expediente_tecnico());
			pstm.setDouble(13, o.getValor_referencial());
			pstm.setString(14, o.getResolucion_aprobacion_valor_referencial());
			pstm.setString(15, o.getFecha_resolucion_aprobacion_valor_referencial());
			pstm.setString(16, o.getResolucion_actualizacion_valor_referencial());
			pstm.setString(17, o.getFecha_resolucion_actualizacion_valor_referencial());
			pstm.setString(18, o.getInforme_tecnico_declaratoria_viabilidad());
			pstm.setString(19, o.getFecha_informe_tecnico_declaratoria_viabilidad());
			pstm.setString(20, o.getBeneficiarios_directos());
			pstm.setString(21, o.getUsuario());

			pstm.setInt(22, o.getId_proyecto());

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
	public List<Datos_proyecto> Listar() throws Exception {
		Connection cn = null;
		List<Datos_proyecto> lista = new ArrayList<Datos_proyecto>();
		try {
			// conexion a la base de datos
			cn = DataAccess.getConnection();
			// comando sql
			String sql = " select id_proyecto,codigo_snip,codigo_proyecto,nombre_pip ,estado_proyecto, usuario "
					+ " from datos_proyecto where activo = 1 order by nombre_pip asc";

			// crear statement
			Statement stm = cn.createStatement();
			// ejecutar comando y obtener resultados
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Datos_proyecto dp = new Datos_proyecto();
				// asignar valores al objeto r
				dp.setId_proyecto(rs.getInt("id_proyecto"));
				dp.setCodigo_snip(rs.getString("codigo_snip"));
				dp.setCodigo_proyecto(rs.getString("codigo_proyecto"));
				dp.setNombre_pip(rs.getString("nombre_pip"));
				dp.setEstado_proyecto(rs.getString("estado_proyecto"));
				dp.setUsuario(rs.getString("usuario"));

				lista.add(dp);
			}
			// cerrar cursor
			rs.close();
			stm.close();
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
	public List<Datos_proyecto> Filtrar(Datos_proyecto o) throws Exception {
		 Connection cn = null;
	        List<Datos_proyecto> lista = new ArrayList<Datos_proyecto>();
	        try {
	            // conexion a la base de datos
	            cn = DataAccess.getConnection();
	            //comando sql
	            String sql =" select codigo_snip,codigo_proyecto,nombre_pip ,estado_proyecto "
						+ " from datos_proyecto where nombre_pip like ? and activo = 1 order by nombre_pip asc";
	            // crear statement
	            PreparedStatement pstm = cn.prepareStatement(sql);
	            // crear parametro y asignar valor
	            pstm.setString(1, "%" + o.getNombre_pip() + "%");

	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	Datos_proyecto dp = new Datos_proyecto();
					// asignar valores al objeto r
					dp.setCodigo_snip(rs.getString("codigo_snip"));
					dp.setCodigo_proyecto(rs.getString("codigo_proyecto"));
					dp.setNombre_pip(rs.getString("nombre_pip"));
					dp.setEstado_proyecto(rs.getString("estado_proyecto"));

					lista.add(dp);
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
	public Datos_proyecto Buscar(Datos_proyecto o) throws Exception {
		 Connection cn = null;
	        Datos_proyecto dp = new Datos_proyecto();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select id_proyecto,codigo_snip, codigo_proyecto, etapa_proyecto, estado_proyecto, "
					+ " ubicacion, nombre_pip, presupuesto_viabilidad, consultor_preinversion, consultor_expediente_tecnico, "
					+ " resolucion_aprobacion_expediente_tecnico, date_format(fecha_resolucion_aprobacion_expediente_tecnico, '%m/%d/%Y') as fecha_resolucion_aprobacion_expediente_tecnico, "
					+ " presupuesto_expediente_tecnico, valor_referencial, resolucion_aprobacion_valor_referencial, "
					+ " date_format(fecha_resolucion_aprobacion_valor_referencial, '%m/%d/%Y') as fecha_resolucion_aprobacion_valor_referencial, resolucion_actualizacion_valor_referencial, "
					+ " date_format(fecha_resolucion_actualizacion_valor_referencial, '%m/%d/%Y')  as fecha_resolucion_actualizacion_valor_referencial, informe_tecnico_declaratoria_viabilidad, "
					+ " date_format(fecha_informe_tecnico_declaratoria_viabilidad, '%m/%d/%Y')  as fecha_informe_tecnico_declaratoria_viabilidad, beneficiarios_directos "
					+ " from datos_proyecto where codigo_snip = ? and activo = 1 ";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setString(1, o.getCodigo_snip());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	dp.setId_proyecto(rs.getInt("id_proyecto"));
	            	dp.setCodigo_snip(rs.getString("codigo_snip"));
	            	dp.setCodigo_proyecto(rs.getString("codigo_proyecto"));
	            	dp.setEtapa_proyecto(rs.getString("etapa_proyecto"));
	            	dp.setEstado_proyecto(rs.getString("estado_proyecto"));
	            	dp.setUbicacion(rs.getString("ubicacion"));
	            	dp.setNombre_pip(rs.getString("nombre_pip"));
	            	dp.setPresupuesto_viabilidad(rs.getDouble("presupuesto_viabilidad"));
	            	dp.setConsultor_preinversion(rs.getString("consultor_preinversion"));
	            	dp.setConsultor_expediente_tecnico(rs.getString("consultor_expediente_tecnico"));
	            	dp.setResolucion_aprobacion_expediente_tecnico(rs.getString("resolucion_aprobacion_expediente_tecnico"));
	            	dp.setFecha_resolucion_aprobacion_expediente_tecnico(rs.getString("fecha_resolucion_aprobacion_expediente_tecnico"));
	            	dp.setPresupuesto_expediente_tecnico(rs.getDouble("presupuesto_expediente_tecnico"));
	            	dp.setValor_referencial(rs.getDouble("valor_referencial"));
	            	dp.setResolucion_aprobacion_valor_referencial(rs.getString("resolucion_aprobacion_valor_referencial"));
	            	dp.setFecha_resolucion_aprobacion_valor_referencial(rs.getString("fecha_resolucion_aprobacion_valor_referencial"));
	            	dp.setResolucion_actualizacion_valor_referencial(rs.getString("resolucion_actualizacion_valor_referencial"));
	            	dp.setFecha_resolucion_actualizacion_valor_referencial(rs.getString("fecha_resolucion_actualizacion_valor_referencial"));		
	            	dp.setInforme_tecnico_declaratoria_viabilidad(rs.getString("informe_tecnico_declaratoria_viabilidad"));
	            	dp.setFecha_informe_tecnico_declaratoria_viabilidad(rs.getString("fecha_informe_tecnico_declaratoria_viabilidad"));	    		
	    			dp.setBeneficiarios_directos(rs.getString("beneficiarios_directos"));
	    				                

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
	        return dp;
	}
	public Datos_proyecto BuscarPorCodigoProyecto(Datos_proyecto o) throws Exception {
		 Connection cn = null;
	        Datos_proyecto dp = new Datos_proyecto();
	        try {
	            cn = DataAccess.getConnection();

	            String sql = " select id_proyecto,codigo_snip, codigo_proyecto, etapa_proyecto, estado_proyecto, "
					+ " ubicacion, nombre_pip, presupuesto_viabilidad, consultor_preinversion, consultor_expediente_tecnico, "
					+ " resolucion_aprobacion_expediente_tecnico, fecha_resolucion_aprobacion_expediente_tecnico, "
					+ " presupuesto_expediente_tecnico, valor_referencial, resolucion_aprobacion_valor_referencial, "
					+ " fecha_resolucion_aprobacion_valor_referencial, resolucion_actualizacion_valor_referencial, "
					+ " fecha_resolucion_actualizacion_valor_referencial, informe_tecnico_declaratoria_viabilidad, "
					+ " fecha_informe_tecnico_declaratoria_viabilidad, beneficiarios_directos "
					+ " from datos_proyecto where codigo_proyecto = ? and activo = 1";

	            PreparedStatement pstm = cn.prepareStatement(sql);
	            
	            pstm.setString(1, o.getCodigo_proyecto());
	            
	            ResultSet rs = pstm.executeQuery();

	            while (rs.next()) {

	            	dp.setId_proyecto(rs.getInt("id_proyecto"));
	            	dp.setCodigo_snip(rs.getString("codigo_snip"));
	            	dp.setCodigo_proyecto(rs.getString("codigo_proyecto"));
	            	dp.setEtapa_proyecto(rs.getString("etapa_proyecto"));
	            	dp.setEstado_proyecto(rs.getString("estado_proyecto"));
	            	dp.setUbicacion(rs.getString("ubicacion"));
	            	dp.setNombre_pip(rs.getString("nombre_pip"));
	            	dp.setPresupuesto_viabilidad(rs.getDouble("presupuesto_viabilidad"));
	            	dp.setConsultor_preinversion(rs.getString("consultor_preinversion"));
	            	dp.setConsultor_expediente_tecnico(rs.getString("consultor_expediente_tecnico"));
	            	dp.setResolucion_aprobacion_expediente_tecnico(rs.getString("resolucion_aprobacion_expediente_tecnico"));
	            	dp.setFecha_resolucion_aprobacion_expediente_tecnico(rs.getString("fecha_resolucion_aprobacion_expediente_tecnico"));
	            	dp.setPresupuesto_expediente_tecnico(rs.getDouble("presupuesto_expediente_tecnico"));
	            	dp.setValor_referencial(rs.getDouble("valor_referencial"));
	            	dp.setResolucion_aprobacion_valor_referencial(rs.getString("resolucion_aprobacion_valor_referencial"));
	            	dp.setFecha_resolucion_aprobacion_valor_referencial(rs.getString("fecha_resolucion_aprobacion_valor_referencial"));
	            	dp.setResolucion_actualizacion_valor_referencial(rs.getString("resolucion_actualizacion_valor_referencial"));
	            	dp.setFecha_resolucion_actualizacion_valor_referencial(rs.getString("fecha_resolucion_actualizacion_valor_referencial"));		
	            	dp.setInforme_tecnico_declaratoria_viabilidad(rs.getString("informe_tecnico_declaratoria_viabilidad"));
	            	dp.setFecha_informe_tecnico_declaratoria_viabilidad(rs.getString("fecha_informe_tecnico_declaratoria_viabilidad"));	    		
	    			dp.setBeneficiarios_directos(rs.getString("beneficiarios_directos"));
	    				                

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
	        return dp;
	}


}
