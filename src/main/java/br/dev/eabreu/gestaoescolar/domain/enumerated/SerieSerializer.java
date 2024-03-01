package br.dev.eabreu.gestaoescolar.domain.enumerated;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class SerieSerializer extends StdSerializer<SerieEnum>{
	
	private static final long serialVersionUID = 1L;
	
	public SerieSerializer() {
		super(SerieEnum.class);
	}
	
	public SerieSerializer(Class<SerieEnum> clazz) {
		super(clazz);
	}

	@Override
	public void serialize(SerieEnum serie, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeStartObject("serie");
		generator.writeFieldName("codigo");
		generator.writeString(serie.toString());
		generator.writeFieldName("nome");
		generator.writeString(serie.getSerie());
		generator.writeEndObject();
	}
}