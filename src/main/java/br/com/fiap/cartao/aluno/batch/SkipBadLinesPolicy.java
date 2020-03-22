package br.com.fiap.cartao.aluno.batch;

import org.springframework.batch.item.file.separator.SimpleRecordSeparatorPolicy;
import org.springframework.stereotype.Component;

@Component
public class SkipBadLinesPolicy extends SimpleRecordSeparatorPolicy {

    @Override
    public boolean isEndOfRecord(String line) {
        return !line.isEmpty() && super.isEndOfRecord(line);
    }

}
