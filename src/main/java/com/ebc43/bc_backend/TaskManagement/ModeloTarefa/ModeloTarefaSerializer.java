package com.ebc43.bc_backend.TaskManagement.ModeloTarefa;

import java.io.IOException;

import com.ebc43.bc_backend.TaskManagement.RecursoHumanoModeloTarefa.RecursoHumanoModeloTarefa;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ModeloTarefaSerializer extends StdSerializer<ModeloTarefa>{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModeloTarefaSerializer() {
	        this(null);
	    }
	 
	    public ModeloTarefaSerializer(Class<ModeloTarefa> t) {
	        super(t);
	    }
	 
	    @Override
	    public void serialize(
	      ModeloTarefa item, 
	      JsonGenerator generator, 
	      SerializerProvider provider) 
	      throws IOException, JsonProcessingException {
	    	
	    	String ubs = null, ubc = null, deleted=null;
	    	
	    	if(item.getCreatedAt() != null) 
	    		ubs = item.getCreatedAt().toString();
	    	if(item.getUpdatedAt() != null)
	    		ubc = item.getUpdatedAt().toString();
	    	if(item.getDeletedAt() != null)
	    		deleted = item.getDeletedAt().toString();
	    	
	        generator.writeStartObject();
	        generator.writeNumberField("id", item.getId());
	        generator.writeObjectField("modeloEquipamento", item.getModeloEquipamento());
	        generator.writeStringField("nome", item.getNome());
	        generator.writeNumberField("periocidadeDias", item.getPeriodicidadeDias());
	        generator.writeFieldName("recursosHumanosModeloTarefa");
		            generator.writeStartArray();
		            for(RecursoHumanoModeloTarefa r : item.getRecursosHumanosModeloTarefa()) {
		            	generator.writeObject(r);
		            }
		            generator.writeEndArray();
	        generator.writeStringField("enderecoInstrucao", item.getEnderecoInstrucao());

	        generator.writeStringField("UpdatedByServer", ubs);
	        generator.writeStringField("UpdatedByClient", ubc);
	        generator.writeStringField("deleted", deleted);
	        generator.writeEndObject();
	        
	    }
}