package com.wang.serialization;

import com.wang.consumer.MySerializerCustomer;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-06 23:28
 **/
public class CustomerSerializer implements Serializer<MySerializerCustomer> {
    @Override
    public byte[] serialize(String topic, MySerializerCustomer data) {

        try {
            byte[] serializedName;
            int stringSize;
            if (data == null) {
                return null;
            } else {
                if (data.getName() != null) {
                    serializedName = data.getName().getBytes("UTF-8");
                    stringSize = serializedName.length;
                } else {
                    serializedName = new byte[0];
                    stringSize = 0;
                }
            }
            ByteBuffer buffer = ByteBuffer.allocate(4 + 4 + stringSize);
            buffer.putInt(data.getId());
            buffer.putInt(stringSize);
            buffer.put(serializedName);

            return buffer.array();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new SerializationException("Error");
        }
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // 不做任何配置
    }

    @Override
    public byte[] serialize(String topic, Headers headers, MySerializerCustomer data) {
        return new byte[0];
    }

    @Override
    public void close() {

    }
}
