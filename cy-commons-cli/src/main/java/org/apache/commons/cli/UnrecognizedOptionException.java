/**
 * Copyright 1999-2001,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.cli;


/**
 * <p>Exception thrown during parsing signalling an unrecognized
 * option was seen.<p>
 *
 * @author bob mcwhiter (bob @ werken.com)
 * @version $Revision: 155404 $
 */
public class UnrecognizedOptionException extends ParseException {
	private final static long serialVersionUID = 1215557233113975L;
	/**
	 * <p>Construct a new <code>UnrecognizedArgumentException</code>
	 * with the specified detail message.</p>
	 *
	 * @param message the detail message
	 */
	public UnrecognizedOptionException(String message) {
		super(message);
	}
}