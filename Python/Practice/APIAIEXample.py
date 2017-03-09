#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os.path
import sys
import json
import pandas as pd

try:
    import apiai
except ImportError:
    sys.path.append(
        os.path.join(os.path.dirname(os.path.realpath(__file__)), os.pardir)
    )
    import apiai

#CLIENT_ACCESS_TOKEN = 'YOUR_ACCESS_TOKEN'
CLIENT_ACCESS_TOKEN = 'd2d1f18d9fa745da99ed897996ee92ad'#devloper token


def main():
    ai = apiai.ApiAI(CLIENT_ACCESS_TOKEN)

    request = ai.text_request()

    request.lang = 'en'  # optional, default value equal 'en'

    request.session_id = "<SESSION ID, UNIQUE FOR EACH USER>"

    request.query = "time now"

    response = request.getresponse()
    data=response.read().decode()
    data1=pd.read_json(data)

    print (data1.result.parameters)


if __name__ == '__main__':
    main()
