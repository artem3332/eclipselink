/*
 * Copyright (c) 2010, 2022 Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2010, 2022 Frank Schwarz. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     11/23/2010-2.2 Frank Schwarz
//       - 328774: TABLE_PER_CLASS-mapped key of a java.util.Map does not work for querying
package org.eclipse.persistence.testing.models.jpa.ddlgeneration.tableperclass;

import jakarta.persistence.Entity;

@Entity
public class CodeExample extends BaseEntity {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
