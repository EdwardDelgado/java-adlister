/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.Collections;
import java.util.List;

public class EmptyUsers  {

    public List<User> all() {
        return Collections.emptyList();
    }

    public Long insert(User user) {
        return null;
    }
}