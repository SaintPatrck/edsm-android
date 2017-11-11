/*
 * Copyright (c) 2017.
 *
 * Copyright 2017 Patrick Honkonen
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.phapps.elitedangerous.edsm.network;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link TypeAdapterFactory} that ensures a JSON element is always deserialized into an array
 * of the given type, {@link E}.
 *
 * @param <E> type of array to deserialize into.
 */
public final class AlwaysListTypeAdapterFactory<E> implements TypeAdapterFactory {

    private AlwaysListTypeAdapterFactory() {
        // gson will instantiate this itself
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

        if (!List.class.isAssignableFrom(type.getRawType())) {
            return null;
        }

        // determine array parameter type
        Type elementType = resolveTypeArgument(type.getType());

        //noinspection unchecked
        TypeAdapter<E> elementTypeAdapter = (TypeAdapter<E>)gson.getAdapter(TypeToken.get(elementType));

        //noinspection unchecked
        return (TypeAdapter<T>)new AlwaysListTypeAdapter<>(elementTypeAdapter).nullSafe();
    }

    private Type resolveTypeArgument(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }

        ParameterizedType parameterizedType = (ParameterizedType)type;
        return parameterizedType.getActualTypeArguments()[0];
    }

    private final class AlwaysListTypeAdapter<F> extends TypeAdapter<List<F>> {

        private TypeAdapter<F> mElementTypeAdapter;

        AlwaysListTypeAdapter(TypeAdapter<F> elementTypeAdapter) {
            mElementTypeAdapter = elementTypeAdapter;
        }

        @Override
        public void write(JsonWriter out, List<F> value) throws IOException {
            throw new UnsupportedOperationException();
        }

        @Override
        public List<F> read(JsonReader in) throws IOException {

            JsonToken token = in.peek();
            List<F> list = new ArrayList<>();
            switch (token) {
                case BEGIN_ARRAY:
                    in.beginArray();
                    while (in.hasNext()) {
                        list.add(mElementTypeAdapter.read(in));
                    }
                    in.endArray();
                    break;
                case BEGIN_OBJECT:
                case STRING:
                case NUMBER:
                case BOOLEAN:
                    list.add(mElementTypeAdapter.read(in));
                    break;
                case NULL:
                    throw new AssertionError("Type Adapter may not be configured with .nullSafe()");
                case NAME:
                case END_ARRAY:
                case END_OBJECT:
                case END_DOCUMENT:
                    throw new MalformedJsonException("Unexpected token: " + token);
                default:
                    throw new AssertionError("Something has gone horribly wrong: " + token);
            }

            return list;
        }
    }
}
