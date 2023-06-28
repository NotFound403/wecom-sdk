package cn.felord.xml;

import okhttp3.ResponseBody;
import retrofit2.Converter;

import java.io.IOException;

/**
 * @author dax
 * @since 2023/6/28 9:44
 */
public class XStreamResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    @Override
    public T convert(ResponseBody value) throws IOException {
        return null;
    }
}
