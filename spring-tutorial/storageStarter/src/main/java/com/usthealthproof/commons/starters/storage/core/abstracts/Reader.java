package com.usthealthproof.commons.starters.storage.core.abstracts;

import java.io.IOException;
import java.util.List;

public interface Reader {
    public List<String> readFromStorage(String filePath, String fileName) throws IOException;
}
