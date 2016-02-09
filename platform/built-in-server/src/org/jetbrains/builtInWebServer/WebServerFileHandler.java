/*
 * Copyright 2000-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jetbrains.builtInWebServer;

import com.intellij.openapi.extensions.ExtensionPointName;
import com.intellij.openapi.project.Project;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.FullHttpRequest;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public abstract class WebServerFileHandler {
  static final ExtensionPointName<WebServerFileHandler> EP_NAME = ExtensionPointName.create("org.jetbrains.webServerFileHandler");

  public abstract boolean process(@NotNull PathInfo pathInfo,
                                  @NotNull CharSequence canonicalRequestPath,
                                  @NotNull Project project,
                                  @NotNull FullHttpRequest request,
                                  @NotNull Channel channel,
                                  boolean isCustomHost) throws IOException;
}