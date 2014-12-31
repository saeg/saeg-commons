/**
 * saeg-commons: common utility methods
 * Copyright (c) 2014, 2015 University of Sao Paulo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holders nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */
package br.usp.each.saeg.commons.reflection;

import java.lang.reflect.Method;

public class ObjectInvocation implements Invocation {

    private final Object target;

    private final Method method;

    public ObjectInvocation(final Object target, final Method method) {

        if (target == null) {
            throw new IllegalArgumentException("Target cannot be null");
        }

        if (method == null) {
            throw new IllegalArgumentException("Method cannot be null");
        }

        if (!method.getDeclaringClass().isAssignableFrom(target.getClass())) {
            // method class isn't assignable
            throw new IllegalArgumentException(String.format(
                    "Method %s cannot be invoked on object %s", method, target));
        }

        this.target = target;
        this.method = method;

    }

    @Override
    public Object call(final Object... args) {
        try {
            return method.invoke(target, args);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

}
