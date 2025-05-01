package com.lobito.dictionary.dtos;

import com.lobito.dictionary.domain.Gender;

public record SlovenianSpanishWordDTO(int wordGroupId,
                                      Gender slovenianGender,
                                      Long slovenianWordId,
                                      Long spanishWordId,
                                      Gender spanishGender,
                                      int categoryId) {

}
