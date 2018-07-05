package project.mapper;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import project.dto.WriterDto;
import project.dto.WriterDtoReg;
import project.entity.Writer;

public class WriterMapper {

    public static User toSecurityUser(Writer writer) {
        return new User(writer.getEmail(), writer.getPassword(), AuthorityUtils.createAuthorityList(String.valueOf(writer.getRole())));
    }

    public static Writer convertToWriter(WriterDto writerDto) {
        Writer writer = new Writer();
        writer.setFullName(writerDto.getFullName());
        writer.setAge(writerDto.getAge());
        writer.setCountry(writerDto.getCountry());
        writer.setImageUrl(writerDto.getImageUrl());
        return writer;
    }

    public static WriterDto convertToDto(Writer writer) {
        WriterDto writerDto = new WriterDto();
        writerDto.setFullName(writer.getFullName());
        writerDto.setAge(writer.getAge());
        writerDto.setCountry(writer.getCountry());
        writerDto.setImageUrl(writer.getImageUrl());
        return writerDto;
    }

    public static Writer convertToWriterReg(WriterDtoReg writerDtoReg) {
        Writer writer = new Writer();
        writer.setFullName(writerDtoReg.getFullName());
        writer.setAge(writerDtoReg.getAge());
        writer.setEmail(writerDtoReg.getEmail());
        writer.setPassword(writerDtoReg.getPassword());
        writer.setCountry(writerDtoReg.getCountry());
        writer.setImageUrl(writerDtoReg.getImageUrl());
        return writer;
    }
}
